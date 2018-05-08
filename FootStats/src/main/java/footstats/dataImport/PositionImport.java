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

    private ArrayList<String> positions = new ArrayList<>();

    @Autowired
    PositionService positionService;
    
    public void importPositions() throws  InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.realbuzz.com/articles-interests/sports-activities/article/player-positions-in-soccer/";
        driver.get(url);

        Actions actions = new Actions(driver);

        for(int i = 1; i < 10; i++) {
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

        }
    }
}
