package footstats.dataImport;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class GameReImport {

    public void importReferees() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.flashscore.com";
        driver.navigate().to(url);

        Actions action = new Actions(driver);



        driver.close();
        driver.quit();
    }

}


//*[@id="lmenu_17"]/ul/li[1]/a
//*[@id="lmenu_18"]/ul/li[1]/a
//*[@id="lmenu_18"]/ul/li[3]/a
