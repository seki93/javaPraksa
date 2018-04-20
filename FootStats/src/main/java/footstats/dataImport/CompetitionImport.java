package footstats.dataImport;

import footstats.model.Competition;
import footstats.model.Country;
import footstats.model.Rank;
import footstats.service.CompetitionService;
import footstats.service.CountryService;
import footstats.service.RankService;
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
import java.sql.ResultSet;
import java.util.ArrayList;

import static footstats.dataImport.CityImport.ENG_CODE;

@Service
public class CompetitionImport {

    final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SekiSelenijum.class);

    private ArrayList<String> englandCompetitions = new ArrayList<>();
    private ArrayList<String> germanyCompetitions = new ArrayList<>();
    private ArrayList<String> italyCompetitions = new ArrayList<>();
    private ArrayList<String> spainCompetitions = new ArrayList<>();
    private ArrayList<String> franceCompetitions = new ArrayList<>();
    private ArrayList<String> serbiaCompetitions = new ArrayList<>();
    private ArrayList<String> internationalCompetitions = new ArrayList<>();

    private ArrayList<String> ranks = new ArrayList<>();

    private int id, idEngland, idGermany, idItaly, idSpain, idFrance, idSerbia, idInternational;

    private int firstRank, secondRank, thirdRank, fourthRank, fifthRank;

    @Autowired
    CompetitionService competitionService;

    @Autowired
    CountryService countryService;

    @Autowired
    RankService rankService;

    public void importCompetitions() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        log.debug("Opening browser");
        driver.manage().window().maximize();
        String url = "https://en.wikipedia.org/wiki/List_of_association_football_competitions";
        log.debug("navigating to the " + url);
        driver.get(url);

        Actions actions = new Actions(driver);

        try {

            int i = 2;

           while(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr["+ i +"]/td[1]/a")).getText() != null){

               Country england = countryService.findByName("England");
               String rankName = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr["+ i +"]/td[2]")).getText().charAt(0)+"";
               Rank rank = rankService.findByName(rankName + "-st");
               if(rank == null) {
                   break;
               }

               Competition competition = new Competition();
               competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr["+ i +"]/td[1]/a")).getText());
               competition.setCountry(england);
               competition.setRank(rank);

               competitionService.save(competition);

               i++;
            }

            /*while(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr["+ i +"]/td[1]/a")).getText() != null){

                Country germany = countryService.findByName("Germany");
                Rank rank = rankService.findByName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr["+ i +"]/td[2]")).getText().charAt(0)+"" );

                Competition competition = new Competition();
                competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr["+ i +"]/td[1]/a")).getText());
                competition.setCountry(germany);
                competition.setRank(rank);

                competitionService.save(competition);

                i++;
            }*/
        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }

        log.debug("Closing browser");
        driver.close();
        driver.quit();
    }
}




//*[@id="England"]/a
//*[@id="mw-content-text"]/div/table[39]/tbody/tr[1]/th[1]/span/a/img
//*[@id="mw-content-text"]/div/table[39]/tbody/tr[1]/th[1]


//*[@id="mw-content-text"]/div/table[]39/tbody/tr[2]/td[1]/a
//*[@id="mw-content-text"]/div/table[38]/tbody/tr[2]/td[1]/a
//*[@id="mw-content-text"]/div/table[39]/tbody/tr[3]/td[1]/a
//*[@id="mw-content-text"]/div/table[39]/tbody/tr[2]/td[2]


/* int i = 2;
while( driver.findElement(By.xpath("*[@id="mw-content-text"]/div/table[39]/tbody/tr["+i+"]/td[1]/a")).getText() ) {
        Country england = countryService.findByName("England");
        Rank rank = rankService.findByName
            driver.findElement(By.xpath("//*[@id="mw-content-text"]/div/table[39]/tbody/tr["+i+"]/td[2]")).getText().charAt(0)+"" );

        Competition competition = new COmpetitoin();
        competitoin.setCountry(england);
        competitio.setRank(rank);
        competitoin.setName(driver.findElement(By.xpath("//*[@id="mw-content-text"]/div/table[39]/tbody/tr["+i+"]/td[1]/a")).getText();
        }


        */