package footstats.dataImport;



import java.io.File;
import java.io.IOException;


import org.apache.log4j.Logger;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;


/**
 * Created by Djordje.Ivanovic on 12/01/2015.
 */
public class StadiumImport {

    final static Logger log = Logger.getLogger(StadiumImport.class);

    @Test
    public void simpleChromeDrivertest() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        log.debug("Opening browser");
        driver.manage().window().maximize();
        String url = "http://stackoverflow.com";
        log.debug("navigating to the "  + url);
        driver.get(url);

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("search")));
        action.sendKeys(driver.findElement(By.id("search")), "jpa").build().perform();

        try {
            driver.findElement(By.id("search")).submit();
        } catch (Exception e) {
            // TODO: handle exception
        }

        Thread.sleep(5000);

        System.out.println(driver.findElement(By.xpath("//*[@data-position='1']/div[2]/div[4]/a")).getText());

        Thread.sleep(5000);
        log.debug("Closing browser");
        driver.close();
        driver.quit();
    }


    /*@Test
    public void getTwitterScreenshot() throws InterruptedException {
     System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
  WebDriver driver= new ChromeDriver();
        driver.navigate().to("http://www.twitter.com/nike");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.close();
        driver.quit();
    }*/

}
