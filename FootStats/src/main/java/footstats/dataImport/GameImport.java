package footstats.dataImport;

import footstats.model.Club;
import footstats.model.Game;
import footstats.service.ClubService;
import footstats.service.GameService;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameImport {

    @Autowired
    private ClubService clubService;

    @Autowired
    private GameService gameService;

    public void gamesDatabaseImportMethod(List<WebElement> lista) {
        String date = lista.get(1).getText();
        String homeClub = lista.get(2).getText();
        String awayClub = lista.get(3).getText();
        String result = lista.get(4).getText();

        System.out.println();

        Game game = new Game();

        if (clubService.findByName(homeClub) == null) {
            Club homeClubUpis = new Club();
            homeClubUpis.setName(homeClub);
            clubService.save(homeClubUpis);
        }
        game.setHomeClub(clubService.findByName(homeClub));

        if (clubService.findByName(awayClub) == null) {
            Club awayClubUpis = new Club();
            awayClubUpis.setName(awayClub);
            clubService.save(awayClubUpis);
        }
        game.setAwayClub(clubService.findByName(awayClub));

        gameService.save(game);

        System.out.println(date + " " + homeClub + " versus " + awayClub + " " + result);

    }

    public void importGames() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.soccer24.com";
        driver.navigate().to(url);

        Actions action = new Actions(driver);

        int i = 17;
        while (i < 250) {
            //prolazi kroz zemlje
            String country = "//*[@id=\"lmenu_" + i + "\"]/a";
            if (driver.findElements(By.xpath(country)).isEmpty()) {
                i++;
                continue;
            }

            int j = 1;
            while (true) { //true
                //ulazi u zemlje
                action.moveToElement(driver.findElement(By.xpath(country)));
                action.click().build().perform();
                Thread.sleep(1000);
                //trazi lige
                String league = "//*[@id=\"lmenu_" + i + "\"]/ul/li[" + j + "]/a";
                if (driver.findElements(By.xpath(league)).isEmpty()) {
                    break;
                }
                //ulazi u lige
                action.moveToElement(driver.findElement(By.xpath(league)));
                action.click().build().perform();

                //ulazi u rezultate lige
                String results = "//*[@id=\"fscon\"]/div[2]/ul/li[2]/span/a";
                action.moveToElement(driver.findElement(By.xpath(results)));
                action.click().build().perform();
                Thread.sleep(2500);

                //otvara show more
                for (int expand = 0; expand < 5; expand++) {

                    ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
                    Thread.sleep(1000);
                    if (!driver.findElements(By.xpath("//*[@id=\"tournament-page-results-more\"]/tbody/tr/td/a")).isEmpty()) {
                        WebElement exp = driver.findElement(By.xpath("//*[@id=\"tournament-page-results-more\"]/tbody/tr/td/a"));
                        action.moveToElement(exp);
                        action.click(exp);
                        action.build().perform();
                    }
                }
                //prolazi kroz meceve
                int z = 2;
                int p = 1;

                if (!driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + z + "]/td")).isEmpty()) {
                    while (!driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + z + "]/td")).isEmpty()) {
                    try {
                        if (driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + z + "]/td")).size()<0){
                            j++;
                            continue;
                            }
                        if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + z + "]/td")).getText().contains("Round")) {
                            z++;
                            continue;
                        }
                        if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + z + "]/td")).getText().contains("Final")) {
                            z++;
                            continue;
                        }
                        if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + z + "]/td")).getText().contains("final")) {
                            z++;
                            continue;
                        }
                        if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + z + "]/td")).getText().contains("place")) {
                            z++;
                            continue;
                        }
                        List<WebElement> lista = driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + z + "]/td"));
                        gamesDatabaseImportMethod(lista);


                    z++;
                    } catch (StaleElementReferenceException e){
                        System.out.println("Bacio exception " + e);
                    }
                }
                    j++;
                } else if (!driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr[1]/td")).isEmpty()) {

                    while (!driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr["+z+"]/td")).isEmpty()) {
                        while (!driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr[" + z + "]/td")).isEmpty()) {
                            try {
                                if (driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr[" + z + "]/td")).size()<0) {
                                    j++;
                                    continue;
                                }
                                if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr[" + z + "]/td")).getText().contains("Round")) {
                                    z++;
                                    continue;
                                }

                                if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr[" + z + "]/td")).getText().contains("Final")) {
                                    z++;
                                    continue;
                                }
                                if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr[" + z + "]/td")).getText().contains("final")) {
                                    z++;
                                    continue;
                                }
                                if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr[" + z + "]/td")).getText().contains("place")) {
                                    z++;
                                    continue;
                                }
                            List<WebElement> listic = driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr[" + z + "]/td"));
                            gamesDatabaseImportMethod(listic);

                            z++;
                            } catch (StaleElementReferenceException e){
                                System.out.println("Bacio exception " + e);
                            }
                        }
                        p++;
                    }
                    j++;
                } else if (driver.findElement(By.xpath("//*[@id=\"fscon\"]/div[1]/div[2]")).getText().contains("Super Cup")) {
                    int t = 1;
                    while (!driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + t + "]/td")).isEmpty()) {
                        try {
                            if (driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + t + "]/td")).size()<0) {
                                t++;
                                continue;
                            }
                            if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + t + "]/td")).getText().contains("Round")) {
                                t++;
                                continue;
                            }
                            if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + t + "]/td")).getText().contains("Final")) {
                                t++;
                                continue;
                            }
                            if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + t + "]/td")).getText().contains("final")) {
                                t++;
                                continue;
                            }
                            if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + t + "]/td")).getText().contains("place")) {
                                t++;
                                continue;
                            }
                        List<WebElement> lista = driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + t + "]/td"));
                        gamesDatabaseImportMethod(lista);


                        t++;
                        } catch (StaleElementReferenceException e){
                            System.out.println("Bacio exception " + e);
                        }
                    }
                    i++;
                }
            }
            i++;
        }
        driver.close();
        driver.quit();
    }
}