package footstats.dataImport;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameReImport {

    public void reImportGame() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.soccer24.com";
        driver.navigate().to(url);

        Actions action = new Actions(driver);

        int i = 17;
        while( i < 250) {

            String country = "//*[@id=\"lmenu_"+i+"\"]/a";
            if(driver.findElements(By.xpath(country)).isEmpty()){
                i++;
                continue;
            }

            int j = 1;
            while(true) {
                action.moveToElement(driver.findElement(By.xpath(country)));
                action.click().build().perform();
                Thread.sleep(1500);

                String league = "//*[@id=\"lmenu_"+i+"\"]/ul/li["+j+"]/a";
                if(driver.findElements(By.xpath(league)).isEmpty()) {
                    break;
                }
                action.moveToElement(driver.findElement(By.xpath(league)));
                action.click().build().perform();
                Thread.sleep(1500);

                String results = "//*[@id=\"fscon\"]/div[2]/ul/li[2]/span/a";
                action.moveToElement(driver.findElement(By.xpath(results)));
                action.click().build().perform();

                Thread.sleep(1500);

                j++;
            }

            i++;
        }

        driver.close();
        driver.quit();
    }

}
<<<<<<< Updated upstream
=======


//*[@id="fscon"]/div[2]/ul/li[2]/span/a
>>>>>>> Stashed changes
