package footstats.dataImport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class PositionImport {

    final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SekiSelenijum.class);

    @Test
    public void simpleChromeDrivertest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        log.debug("Opening browser");
        driver.manage().window().maximize();
        String url = "https://www.realbuzz.com/articles-interests/sports-activities/article/player-positions-in-soccer/";
        log.debug("navigating to the " + url);
        driver.get(url);
        WebElement position = driver.findElement(By.xpath("/html/body/div[4]/section/main/article/div[4]/div/div/h3[1]"));

        for(int i = 1;i <= 9; i++){

            
        }

        Actions actions = new Actions(driver);
        actions.moveToElement(position);
        actions.build().perform();
        position.submit();
        System.out.println(position.getText());
        Thread.sleep(5000);
        log.debug("Closing browser");
        driver.close();
        driver.quit();
    }

}
