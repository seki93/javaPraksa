package footstats.dataImport;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import footstats.model.Club;
import footstats.model.Game;
import footstats.model.MatchStats;
import footstats.service.ClubService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        String url = "https://www.sportinglife.com/football/results/competitions/english-premier-league/1/2017-08";
        driver.navigate().to(url);
        int i = 2;

        //Lista kroz mesece
        while (!driver.findElements(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div/div/nav/ul/li["+ i +"]/a")).isEmpty()) {
            //Ulazi u mesec
            WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div/div/nav/ul/li["+i+"]/a"));
            System.out.println(element.getText());
            actions.moveToElement(element);
            actions.click(element);
            actions.build().perform();
            int j = 1;
            int z = 1;
        // PUCA KADA DODJE DO SEPTEMBRA, PRVI MEC

             while(!driver.findElements(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div/div/div/ul/li[" + j + "]/div/div/div[2]/ul/li[1]/div/div/a/div/div")).isEmpty()) {

//                 if (!driver.findElements(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div/div/div/ul/li[" + j + "]/div/div/div[2]/ul/li/div/div/a/div/div")).isEmpty()){
//
//                     WebElement matches1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div/div/div/ul/li["+j+"]/div/div/div[2]/ul/li/div/div/a/div/div"));
//                     System.out.println(matches1.getText());
//                     actions.moveToElement(matches1);
//                     actions.click(matches1);
//                     actions.build().perform();
//                     driver.navigate().to(url);
//                     j++;
//                 }
                 while (!driver.findElements(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div/div/div/ul/li[" + j + "]/div/div/div[2]/ul/li[" + z + "]/div/div/a/div/div")).isEmpty()) {

                     WebElement matches = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div/div/div/ul/li[" + j + "]/div/div/div[2]/ul/li[" + z + "]/div/div/a/div/div"));
                     System.out.println(matches.getText());
                     actions.moveToElement(matches);
                     actions.click(matches);
                     actions.build().perform();
                     z++;
                     driver.navigate().to(url);
                 }
                 z = 1;
                 j++;
            }
            i++;
        }
        driver.close();
        driver.quit();
    }
}

//*[@id="content"]/div/div/div[3]/div/div/div/ul/li[1]/div/div/div[2]/ul/li/div/div/a/div/div




//*[@id="content"]/div/div/div[3]/div/div/div/ul/li[3]/div/div/div[2]/ul/li/div/div/a/div/div
//*[@id="content"]/div/div/div[3]/div/div/div/ul/li[4]/div/div/div[2]/ul/li[1]/div/div/a/div/div




//             String hometeam = driver.findElement(By.xpath("")).getText();
//             String awayteam = driver.findElement(By.xpath("")).getText();
//             String result = driver.findElement(By.xpath("")).getText();
// pravi game, setuje home team i away team, setuje matchstats ID
//            Game game = new Game();
//            Club homeTeam = clubService.findByName(hometeam);
//            game.setHomeClub(homeTeam);
//            Club awayTeam = clubService.findByName(awayteam);
//            game.setAwayClub(awayTeam);
//            MatchStats matchStats = new MatchStats();
//            game.setMatchStats(matchStats);