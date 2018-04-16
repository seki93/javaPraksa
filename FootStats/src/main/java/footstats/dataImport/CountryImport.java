package footstats.dataImport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class CountryImport {

    @Test
    public void simpleChromeDrivertest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        String url = "https://en.wikipedia.org/wiki/List_of_association_football_stadiums_by_country";
        driver.navigate().to(url);
        ArrayList<String> countries = new ArrayList<String>();
        for (int i = 1; i < 79; i++){

                String a = driver.findElement(By.xpath("//*[@id=\"toc\"]/ul/li["+i+"]/a/span[2]")).getText();
                countries.add(a);
        }
        driver.close();
        driver.quit();
        System.out.println(countries);

        try {

            String myUrl = "jdbc:mysql://localhost:3306/footstats";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            String query = " Insert into country (name) values(?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            conn.setAutoCommit(false);


            for(String s: countries){
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

