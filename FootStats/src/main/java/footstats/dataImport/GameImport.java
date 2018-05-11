package footstats.dataImport;

import footstats.model.Club;
import footstats.model.Game;
import footstats.service.ClubService;
import footstats.service.GameService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void importGames() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

            String url = "https://www.soccer24.com/england/premier-league/results/";
            driver.navigate().to(url);

            Actions action = new Actions(driver);

            for (int expand = 0; expand < 5; expand++){

                        ((JavascriptExecutor)driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
                        Thread.sleep(2000);
                        WebElement exp = driver.findElement(By.xpath("//*[@id=\"tournament-page-results-more\"]/tbody/tr/td/a"));

                        action.moveToElement(exp);
                        action.click(exp);
                        action.build().perform();
            }

            int j = 1;
            while(!driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + j + "]/td")).isEmpty()) {

//                if(driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + j + "]/td")).size() < 0) {
//                    j++;
//                    continue;
//                }
                if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr["+j+"]/td")).getText().contains("Round")){
                    j++;
                    continue;
                }
                if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr["+j+"]/td")).getText().contains("final")){
                    j++;
                    continue;
                }
                if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr["+j+"]/td")).getText().contains("place")){
                    j++;
                    continue;
                }

                List<WebElement> lista = driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + j + "]/td"));

                String date = lista.get(1).getText();
                String homeClub = lista.get(2).getText();
                String awayClub = lista.get(3).getText();
                String result = lista.get(4).getText();

                Game game = new Game();
                if(clubService.findByName(homeClub) == null){
                    Club homeClubUpis = new Club();
                    homeClubUpis.setName(homeClub);
                    clubService.save(homeClubUpis);
                }
                game.setHomeClub(clubService.findByName(homeClub));

                if(clubService.findByName(awayClub) == null){
                    Club awayClubUpis = new Club();
                    awayClubUpis.setName(awayClub);
                    clubService.save(awayClubUpis);
                }
                game.setAwayClub(clubService.findByName(awayClub));

                gameService.save(game);
                System.out.println(date +" "+ homeClub+ " versus " + awayClub +" "+ result);

                j++;
            }
            driver.close();
            driver.quit();
        }
    }