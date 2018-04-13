package footstats.dataImport;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


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

    private ArrayList<String> stadiums = new ArrayList<String>();

    @Test
    public void simpleChromeDrivertest() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        log.debug("Opening browser");
        driver.manage().window().maximize();

        String url = "https://en.wikipedia.org/wiki/List_of_association_football_stadiums_by_country";
        driver.get(url);

        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr"));

        for(int i = 2; i <= 83; i++){
            rows = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table["+i+"]/tbody/tr"));
            if(i == 54) i++;
            for(int j = 2; j < rows.size(); j++){
                if(i == 21 || i == 40 || i == 39 || i == 47 || i == 48 || i == 69 || i == 70){                                 //*[@id="mw-content-text"]/div/table[39]/tbody/tr[3]/td[2]
                    stadiums.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table["+i+"]/tbody/tr["+j+"]/td[2]")).getText());
                }else {
                    stadiums.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table["+i+"]/tbody/tr["+j+"]/td[1]")).getText());
                }
            }
        }

        for(String a: stadiums){
            System.out.println(a);
        }

        driver.close();
        driver.quit();

        System.out.println("UKUPNO STADIONA: "+stadiums.size());

        try {

            String myUrl = "jdbc:mysql://localhost:3306/footstats";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            String query = " Insert into stadium (name) values(?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            conn.setAutoCommit(false);


            for(String s: stadiums){
                preparedStmt.setString(1, s);
                preparedStmt.addBatch();
            }
            preparedStmt.executeBatch();
            conn.commit();

            conn.close();
        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
    }


}
