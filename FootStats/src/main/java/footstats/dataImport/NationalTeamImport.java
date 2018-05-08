package footstats.dataImport;

import footstats.model.Competition;
import footstats.model.Country;
import footstats.model.NationalTeam;
import footstats.service.CompetitionService;
import footstats.service.CountryService;
import footstats.service.NationalTeamService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NationalTeamImport {

    private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(NationalTeamImport.class);

    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private NationalTeamService nationalTeamService;

    public void importNationalTeams() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        log.debug("Opening browser");
        driver.manage().window().maximize();


        String url = "https://en.wikipedia.org/wiki/2018_FIFA_World_Cup_qualification";
        importWorldCupNationalTeams(driver, url);

        url = "https://en.wikipedia.org/wiki/2017_FIFA_Confederations_Cup";
        importConfederationsCupNationalTeams(driver, url);

        url = "https://en.wikipedia.org/wiki/UEFA_Euro_2016";
        importEuropeanChampionShipNationalTeams(driver, url);


        driver.close();
        driver.quit();
    }

    private void importWorldCupNationalTeams(WebDriver driver, String url) throws InterruptedException {
        driver.get(url);

        Thread.sleep(3000);

        int i = 1;

        while (!driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[" + i + "]/td[1]/span/a")).isEmpty()) {

            Competition international = competitionService.findByName("World Cup");

            Country country = countryService.findByName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[" + i + "]/td[1]/span/a")).getText());

            NationalTeam nationalTeam = new NationalTeam();
            nationalTeam.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[" + i + "]/td[1]/span/a")).getText());
            nationalTeam.setCompetition(international);
            nationalTeam.setCountry(country);
            nationalTeamService.save(nationalTeam);

            i++;
        }
    }

    private void importConfederationsCupNationalTeams(WebDriver driver, String url) throws  InterruptedException {
        driver.get(url);

        Thread.sleep(3000);

        int i = 1;

        while (!driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[" + i + "]/td[1]/span/a")).isEmpty()) {

            Competition international = competitionService.findByName("Confederations Cup");

            Country country = countryService.findByName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[" + i + "]/td[1]/span/a")).getText());

            NationalTeam nationalTeam = new NationalTeam();
            nationalTeam.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[" + i + "]/td[1]/span/a")).getText());
            nationalTeam.setCompetition(international);
            nationalTeam.setCountry(country);
            nationalTeamService.save(nationalTeam);

            i++;
        }
    }

    private void importEuropeanChampionShipNationalTeams(WebDriver driver, String url) throws InterruptedException {
        driver.get(url);

        Thread.sleep(3000);

        int i = 1;

        while (!driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[3]/tbody/tr["+ i +"]/td[1]/span/a")).isEmpty()) {

            Competition international = competitionService.findByName("UEFA European Championship");

            Country country = countryService.findByName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[3]/tbody/tr["+ i +"]/td[1]/span/a")).getText());

            NationalTeam nationalTeam = new NationalTeam();
            nationalTeam.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[3]/tbody/tr["+ i +"]/td[1]/span/a")).getText());
            nationalTeam.setCompetition(international);
            nationalTeam.setCountry(country);
            nationalTeamService.save(nationalTeam);

            i++;
        }
    }


}
