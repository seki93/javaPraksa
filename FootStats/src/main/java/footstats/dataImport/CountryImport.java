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
    public void importCountries() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        String url = "https://country-code.cl/";
        driver.navigate().to(url);
        ArrayList<String> countries = new ArrayList<String>();
        ArrayList<String> countryCodes = new ArrayList<>();
        countries.add("International");
        countryCodes.add("INT");


        for (int i = 0; i < 249; i++){

                String a = driver.findElement(By.xpath("//*[@id=\"row"+i+"\"]/td[3]/span[3]")).getText();
                String b = driver.findElement(By.xpath("//*[@id=\"row"+i+"\"]/td[5]")).getText();
                countries.add(a);
                countryCodes.add(b);
        }
        driver.close();
        driver.quit();
        System.out.println(countries);
        System.out.println(countryCodes);

        try {
            String myUrl = "jdbc:mysql://localhost:3306/footstats";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            String query = " Insert into country (name, countrycodes) values(?,?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            conn.setAutoCommit(false);

            for(int i = 0; i < countries.size(); i++){
                preparedStmt.setString(1, countries.get(i));
                preparedStmt.setString(2, countryCodes.get(i));
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


//*[@id="row0"]/td[3]/span[3]    //*[@id="row0"]/td[5]
                                 //*[@id="row1"]/td[5]
//*[@id="row1"]/td[3]/span[3]
//*[@id="row2"]/td[3]/span[3]
//*[@id="row17"]/td[3]/span[3]

//*[@id="row248"]/td[3]/span[3]   //*[@id="row248"]/td[5]
