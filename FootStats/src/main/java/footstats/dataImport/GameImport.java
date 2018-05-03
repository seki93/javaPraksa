package footstats.dataImport;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import footstats.model.Club;
import footstats.model.Game;
import footstats.model.MatchStats;
import footstats.service.ClubService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameImport {

    @Autowired
    ClubService clubService;

    final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(GameImport.class);

    public void importGames() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        String url = "http://www.skysports.com/premier-league-results";
        driver.navigate().to(url);

        int i = 1;

        while ( !driver.findElements(By.xpath("//*[@id=\"widgetLite-5\"]/div["+ i +"]/a/span[2]/span/span")).isEmpty()){
                String hometeam = driver.findElement(By.xpath("//*[@id=\"widgetLite-5\"]/div["+ i +"]/a/span[2]/span/span")).getText();
                String awayteam = driver.findElement(By.xpath("//*[@id=\"widgetLite-5\"]/div["+ i +"]/a/span[4]/span/span")).getText();
                String result = driver.findElement(By.xpath("//*[@id=\"widgetLite-5\"]/div[" + i + "]/a/span[3]/span[1]")).getText();

                // pravi game, setuje home team i away team, setuje matchstats ID
//            Game game = new Game();
//            Club homeTeam = clubService.findByName(hometeam);
//            game.setHomeClub(homeTeam);
//            Club awayTeam = clubService.findByName(awayteam);
//            game.setAwayClub(awayTeam);
//            MatchStats matchStats = new MatchStats();
//            game.setMatchStats(matchStats);




            //Trazi po match polju
                if ( !driver.findElements(By.xpath("//*[@id=\"widgetLite-5\"]/div[" + i +"]/a")).isEmpty()){
                WebElement element = driver.findElement(By.xpath("//*[@id=\"widgetLite-5\"]/div[" + i +"]/a"));

                actions.moveToElement(element);
                actions.click(element);
                actions.build().perform();
                //Trazi Stats element


                    for (int j = 1; j < 10; j++){

                        if ( driver.findElement(By.xpath("//*[@id=\"page-nav\"]/ul/li["+ j +"]/a")).getText() == "Stats") {

                            WebElement elementStats = driver.findElement(By.xpath("//*[@id=\"page-nav\"]/ul/li[9]/a"));

                            // ulazi u Stats element
                            actions.moveToElement(elementStats);
                            actions.click(elementStats);
                            actions.build().perform();

                            Thread.sleep(2000);
                            Integer pasovi1 = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"widgetLite-2\"]/div[1]/div[4]/div[1]/div/div[3]/div[3]/span[1]/span")).getText());
                            Integer pasovi2 = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"widgetLite-2\"]/div[1]/div[4]/div[1]/div/div[3]/div[3]/span[2]/span")).getText());
                            System.out.println(pasovi1);
                            System.out.println(pasovi2);
                            int zbirpasova = pasovi1 + pasovi2;

                            System.out.println("Zbir pasova = " + zbirpasova);

                            driver.navigate().to(url);
                        }
                    }
                }

                i++;
        }


        //*[@id="page-nav"]/ul/li[9]/a
        //*[@id="page-nav"]/ul/li[9]/a


//            Thread.sleep(3000);

            driver.close();
            driver.quit();



    }
}


//http://www.skysports.com/football-results
//*[@id="widgetLite-2"]/div[1]/div[4]/div[1]/div/div[1]/div/span[1]/span
//*[@id="widgetLite-2"]/div[1]/div[4]/div[1]/div/div[1]/div/span[1]/span


