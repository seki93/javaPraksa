package footstats.dataImport;

import java.util.ArrayList;
import java.util.List;


import footstats.model.Stadium;
import footstats.service.StadiumService;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StadiumImport {

    final static Logger log = Logger.getLogger(StadiumImport.class);

    private ArrayList<String> stadiums = new ArrayList<String>();

    @Autowired
    StadiumService stadiumService;

    public void importStadiums() throws InterruptedException{
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

        driver.close();
        driver.quit();

         try {
             for(String s: stadiums) {
                 Stadium stadium = new Stadium();
                 stadium.setName(s);
                 stadiumService.save(stadium);
             }
         } catch (Exception e) {
             log.debug("Got an exception!");
             log.debug(e.getMessage());
         }

    }
}
