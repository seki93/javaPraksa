package footstats.dataImport;

import footstats.model.Position;
import footstats.service.PositionService;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

@Service
public class PositionImport {

    final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SekiSelenijum.class);
    private ArrayList<String> positions = new ArrayList<>();

    @Autowired
    PositionService positionService;

    @Test
    public void simpleChromeDrivertest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        log.debug("Opening browser");
        driver.manage().window().maximize();
        String url = "https://www.realbuzz.com/articles-interests/sports-activities/article/player-positions-in-soccer/";
        log.debug("navigating to the " + url);
        driver.get(url);

        Actions actions = new Actions(driver);

        Thread.sleep(5000);

        positions.add(driver.findElement(By.xpath("/html/body/div[4]/section/main/article/div[4]/div/div/h3[1]")).getText());
        positions.add(driver.findElement(By.xpath("/html/body/div[4]/section/main/article/div[4]/div/div/h3[2]")).getText());
        positions.add(driver.findElement(By.xpath("/html/body/div[4]/section/main/article/div[4]/div/div/h3[3]")).getText());
        positions.add(driver.findElement(By.xpath("/html/body/div[4]/section/main/article/div[4]/div/div/h3[4]")).getText());
        positions.add(driver.findElement(By.xpath("/html/body/div[4]/section/main/article/div[4]/div/div/h3[5]")).getText());
        positions.add(driver.findElement(By.xpath("/html/body/div[4]/section/main/article/div[4]/div/div/h3[6]")).getText());
        positions.add(driver.findElement(By.xpath("/html/body/div[4]/section/main/article/div[4]/div/div/h3[7]")).getText());
        positions.add(driver.findElement(By.xpath("/html/body/div[4]/section/main/article/div[4]/div/div/h3[8]")).getText());

        System.out.println(positions);

        try {

            String myUrl = "jdbc:mysql://localhost:3306/footstats";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            String query = " Insert into position (name) values(?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query);

            for(int i = 0;i < positions.size();i++) {

                preparedStmt.setString(1, "" + positions.get(i));
                preparedStmt.execute();

            }

            conn.close();

        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }

        Thread.sleep(5000);
        log.debug("Closing browser");
        driver.close();
        driver.quit();
    }

    public void importPositions() throws  InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        log.debug("Opening browser");
        driver.manage().window().maximize();
        String url = "https://www.realbuzz.com/articles-interests/sports-activities/article/player-positions-in-soccer/";
        log.debug("navigating to the " + url);
        driver.get(url);

        Actions actions = new Actions(driver);

        for(int i = 1; i < 9; i++) {
            positions.add(driver.findElement(By.xpath("/html/body/div[4]/section/main/article/div[4]/div/div/h3["+i+"]")).getText());
        }

        driver.close();
        driver.quit();

        try {
            for(int i = 0; i < positions.size(); i++) {
                Position position = new Position();
                position.setName(positions.get(i));
                positionService.save(position);
            }
        } catch (Exception e) {
            log.debug("Got an exception!");
            log.debug(e.getMessage());
        }
    }
}
