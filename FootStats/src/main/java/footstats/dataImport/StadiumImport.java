package footstats.dataImport;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


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

    private ArrayList<String> premierLeagueStadiums = new ArrayList<String>();
    private ArrayList<String> primeraLeagueStadiums = new ArrayList<String>();

    @Test
    public void simpleChromeDrivertest() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        log.debug("Opening browser");
        driver.manage().window().maximize();
        String url = "https://en.wikipedia.org/wiki/2017%E2%80%9318_Premier_League";
        log.debug("navigating to the "  + url);
        driver.get(url);

        Actions action = new Actions(driver);
        //action.moveToElement(driver.findElement(By.id("search")));
       // action.sendKeys(driver.findElement(By.id("search")), "jpa").build().perform();

        try {
            driver.findElement(By.id("search")).submit();
        } catch (Exception e) {
            // TODO: handle exception
        }
//        // Get the content or container
//        WebElement content = driver.findElement(By.id("contentText"));
//
//        //Get the table of users
//        WebElement tblUsers = content.findElement(By.xpath(".//table/tbody/tr[2]/td/table/tbody/tr/td[1]/table"));
//
//        // Get the rows which change always as and when users are added
//        WebElement allUsers = tblUsers.findElements(By.xpath(".//tbody/tr"));
//
//        // Loop through each row of users table
//        for(WebElement user : allUsers) {
//
//            // Get the username
//            WebElement username = user.findElement(By.xpath(".//td/table/tbody/tr/td[1]/strong[2]"));
//            System.out.println("Username: " + username.getText());
//        }

        Thread.sleep(5000);
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        //System.out.println(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody")).getText());
        //PREMIER STADIUMS
        for(int i = 1; i <= 20; i ++){
            //System.out.println(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr["+i+"]/td[3]")).getText());
            premierLeagueStadiums.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr["+i+"]/td[3]")).getText());
        }

        //PRIMERA STADIUMS
        for(int i = 1; i <= 20; i ++){
            //System.out.println(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr["+i+"]/td[3]")).getText());
            primeraLeagueStadiums.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr["+i+"]/td[3]")).getText());
        }

        System.out.println(premierLeagueStadiums);
        System.out.println(primeraLeagueStadiums);

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
