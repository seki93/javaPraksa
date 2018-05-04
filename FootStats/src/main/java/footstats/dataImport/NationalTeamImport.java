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


        String url = "http://www.fifa.com/worldcup/teams/index.html";
        driver.get(url);


        int i = 1;
        int j = 1;

        while (i < 7){
            while (!driver.findElements(By.xpath("//*[@id=\"qualifiedteamscontainer\"]/div["+ i +"]/div/ul/li["+ j +"]/a/span")).isEmpty()){

                if(i != 5) {
                    Competition international = competitionService.findByName("World Cup");

                    Country country = countryService.findByName(driver.findElement(By.xpath("//*[@id=\"qualifiedteamscontainer\"]/div[" + i + "]/div/ul/li[" + j + "]/a/span")).getText());

                    NationalTeam nationalTeam = new NationalTeam();
                    nationalTeam.setName(driver.findElement(By.xpath("//*[@id=\"qualifiedteamscontainer\"]/div[" + i + "]/div/ul/li[" + j + "]/a/span")).getText());
                    nationalTeam.setCompetition(international);
                    nationalTeam.setCountry(country);
                    nationalTeamService.save(nationalTeam);
                    j++;
                }
            }
            j = 1;
            i++;
        }

//        String url1 = "http://www.fifa.com/confederationscup/teams/index.html";
//        driver.get(url1);



        driver.close();
        driver.quit();


    }
}
