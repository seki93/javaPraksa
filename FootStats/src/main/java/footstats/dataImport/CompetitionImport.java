package footstats.dataImport;

import footstats.model.Competition;
import footstats.model.Country;
import footstats.service.CompetitionService;
import footstats.service.CountryService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitionImport {

    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private CountryService countryService;


    public void importCompetitions() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.soccer24.com";
        driver.navigate().to(url);

        Actions action = new Actions(driver);

        int i = 17;
        while( i < 250) {

            String countryPath = "//*[@id=\"lmenu_"+i+"\"]/a";
            if(driver.findElements(By.xpath(countryPath)).isEmpty()){
                i++;
                continue;
            }

            int j = 1;
            while(true) {
                action.moveToElement(driver.findElement(By.xpath(countryPath)));
                action.click().build().perform();
                Thread.sleep(1500);

                String leaguePath = "//*[@id=\"lmenu_"+i+"\"]/ul/li["+j+"]/a";
                if(driver.findElements(By.xpath(leaguePath)).isEmpty()) {
                    break;
                }
                action.moveToElement(driver.findElement(By.xpath(leaguePath)));
                action.click().build().perform();
                Thread.sleep(2000);

                String countryName = driver.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div[2]/div[1]/div[1]/div/span")).getText();
                Country country = countryService.findByName(countryName);

                String leagueName = driver.findElement(By.xpath("//*[@id=\"fscon\"]/div[1]/div[2]")).getText();

                Competition competition = new Competition();
                competition.setCountry(country);
                competition.setName(leagueName);

                competitionService.save(competition);

                Thread.sleep(1500);

                j++;
            }

            i++;
        }


        driver.close();
        driver.quit();
    }
}



