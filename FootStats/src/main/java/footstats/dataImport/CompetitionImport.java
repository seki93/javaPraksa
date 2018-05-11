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
        addCompetitions(driver, url);

        url = "https://www.soccer24.com/africa/world-cup/teams/";
        addWorldCupCompetition(driver, url);

        url = "https://www.soccer24.com";
        addInternationalCompetitions(driver, url);

        driver.close();
        driver.quit();

    }

    private void addCompetitions(WebDriver driver, String url) throws InterruptedException {
        driver.get(url);

        Actions action = new Actions(driver);

        int i = 17;
        while (i < 350) {

            String countryPath = "//*[@id=\"lmenu_" + i + "\"]/a";
            if (driver.findElements(By.xpath(countryPath)).isEmpty()) {
                i++;
                continue;
            }

            int j = 1;
            while (true) {
                action.moveToElement(driver.findElement(By.xpath(countryPath)));
                action.click().build().perform();
                Thread.sleep(1000);

                String leaguePath = "//*[@id=\"lmenu_" + i + "\"]/ul/li[" + j + "]/a";
                if (driver.findElements(By.xpath(leaguePath)).isEmpty()) {
                    break;
                }

                action.moveToElement(driver.findElement(By.xpath(leaguePath)));
                action.click().build().perform();
                Thread.sleep(1000);

                String countryName = driver.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div[2]/div[1]/div[1]/div/span")).getText();
                Country country;
                if (countryService.findByName(countryName) == null) {
                    country = new Country();
                    country.setName(countryName);
                    countryService.save(country);
                } else {
                    country = countryService.findByName(countryName);
                }

                String leagueName = driver.findElement(By.xpath("//*[@id=\"fscon\"]/div[1]/div[2]")).getText();

                Competition competition = new Competition();
                competition.setCountry(country);
                competition.setName(leagueName);

                competitionService.save(competition);

                j++;
            }

            i++;
        }
    }

    private void addInternationalCompetitions(WebDriver driver, String url) throws InterruptedException {
        driver.get(url);

        Actions action = new Actions(driver);

        int i = 1;
        while (i < 10) {

            String path = "//*[@id=\"lmenu_" + i + "\"]/a";
            if (driver.findElements(By.xpath(path)).isEmpty()) {
                i++;
                continue;
            }

            int j = 1;
            while (true) {
                action.moveToElement(driver.findElement(By.xpath(path)));
                action.click().build().perform();
                Thread.sleep(1000);

                String leaguePath = "//*[@id=\"lmenu_" + i + "\"]/ul/li[" + j + "]/a";
                if (driver.findElements(By.xpath(leaguePath)).isEmpty()) {
                    break;
                }

                action.moveToElement(driver.findElement(By.xpath(leaguePath)));
                action.click().build().perform();
                Thread.sleep(1000);

                if (driver.findElement(By.xpath("//*[@id=\"fscon\"]/div[1]/div[2]")).getText().contains("World Cup 2018")) {
                    j++;
                    continue;
                }

                    Country country = countryService.findByName("International");

                    String leagueName = driver.findElement(By.xpath("//*[@id=\"fscon\"]/div[1]/div[2]")).getText();

                    Competition competition = new Competition();
                    competition.setCountry(country);
                    competition.setName(leagueName);

                    competitionService.save(competition);

                    j++;

            }

            i++;
        }
    }

    private void addWorldCupCompetition(WebDriver driver, String url) throws InterruptedException {
        driver.get(url);

        if(driver.findElement(By.xpath("//*[@id=\"mt\"]/li[4]/a")).getText() != null) {

            Country country = countryService.findByName("International");

            String leagueName = driver.findElement(By.xpath("//*[@id=\"mt\"]/li[4]/a")).getText();

            Competition competition = new Competition();
            competition.setCountry(country);
            competition.setName(leagueName);

            competitionService.save(competition);
        }


    }
}

