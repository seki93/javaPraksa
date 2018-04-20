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

            /*int i = 2;

           while(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr["+ i +"]/td[1]/a")).getText() != null){

               Country england = countryService.findByName("England");
               String rankName = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr["+ i +"]/td[2]")).getText().charAt(0)+"";
               Rank rank = rankService.findByName(rankName);
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

            int j = 2;

            while(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[42]/tbody/tr["+ j +"]/td[2]/a")).getText() != null) {

                Country germany = countryService.findByName("Germany");
                String rankName = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[42]/tbody/tr[" + j + "]/td[3]")).getText().charAt(0) + "";
                Rank rank = rankService.findByName(rankName);
                if (rank == null) {
                    break;
                }

                Competition competition = new Competition();
                competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[42]/tbody/tr[" + j + "]/td[2]/a")).getText());
                competition.setCountry(germany);
                competition.setRank(rank);

                competitionService.save(competition);

                j++;
            }

            int m = 2;

            while(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[50]/tbody/tr["+ m +"]/td[2]/a")).getText() != null){

                Country spain = countryService.findByName("Spain");
                String rankName = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[50]/tbody/tr["+ m +"]/td[3]")).getText().charAt(0)+"";
                Rank rank = rankService.findByName(rankName);
                if(rank == null) {
                    break;
                }

                Competition competition = new Competition();
                competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[50]/tbody/tr["+ m +"]/td[2]/a")).getText());
                competition.setCountry(spain);
                competition.setRank(rank);

                competitionService.save(competition);

                m++;
            }

            int n = 2;

            while(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[41]/tbody/tr["+ n +"]/td[1]/a")).getText() != null){

                Country france = countryService.findByName("France");
                String rankName = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[41]/tbody/tr["+ n +"]/td[2]")).getText().charAt(0)+"";
                Rank rank = rankService.findByName(rankName);
                if(rank == null) {
                    break;
                }

                Competition competition = new Competition();
                competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[41]/tbody/tr["+ n +"]/td[1]/a")).getText());
                competition.setCountry(france);
                competition.setRank(rank);

                competitionService.save(competition);

                n++;
            }

            int p = 2;

            while(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[49]/tbody/tr["+ p +"]/td[2]/a")).getText() != null){

                Country serbia = countryService.findByName("Serbia");
                String rankName = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[48]/tbody/tr["+ p +"]/td[2]")).getText().charAt(0)+"";
                Rank rank = rankService.findByName(rankName);
                if(rank == null) {
                    break;
                }

                Competition competition = new Competition();
                competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[49]/tbody/tr["+ p +"]/td[2]/a")).getText());
                competition.setCountry(serbia);
                competition.setRank(rank);

                competitionService.save(competition);

                p++;
            }*/

            String url1 = "https://en.wikipedia.org/wiki/Italian_football_league_system";
            driver.get(url1);

            int k = 3;

            while(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[3]/tbody/tr["+ k +"]/td[2]/b/a")).getText() != null){

                Country italy = countryService.findByName("Italy");
                String rankName = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[3]/tbody/tr["+ k +"]/td[1]")).getText();
                Rank rank = rankService.findByName(rankName);
                if(rank == null) {
                    break;
                }

                Competition competition = new Competition();
                competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[3]/tbody/tr["+ k +"]/td[2]/b/a")).getText());
                competition.setCountry(italy);
                competition.setRank(rank);

                competitionService.save(competition);

                k++;
            }

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
//*[@id="mw-content-text"]/div/ul[146]/li


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

//*[@id="mw-content-text"]/div/table[50]/tbody/tr[2]/td[2]/a

//*[@id="mw-content-text"]/div/table[50]/tbody/tr[6]/td[2]/a

//*[@id="mw-content-text"]/div/table[50]/tbody/tr[2]/td[3]

//*[@id="mw-content-text"]/div/table[50]/tbody/tr[6]/td[3]

//*[@id="mw-content-text"]/div/table[42]/tbody/tr[2]/td[2]/a

//*[@id="mw-content-text"]/div/table[42]/tbody/tr[6]/td[2]/a

//*[@id="mw-content-text"]/div/table[39]/tbody/tr[2]/td[1]/a

//*[@id="mw-content-text"]/div/table[39]/tbody/tr[6]/td[1]/a

//*[@id="mw-content-text"]/div/table[3]/tbody/tr[3]/td[2]/b/a
//*[@id="mw-content-text"]/div/table[3]/tbody/tr[8]/td[2]/b/a
//*[@id="mw-content-text"]/div/table[3]/tbody/tr[6]/td[2]/b

//*[@id="mw-content-text"]/div/table[3]/tbody/tr[3]/td[1]
//*[@id="mw-content-text"]/div/table[3]/tbody/tr[4]/td[1]
//*[@id="mw-content-text"]/div/table[3]/tbody/tr[5]/td[1]
//*[@id="mw-content-text"]/div/table[3]/tbody/tr[7]/td[1]
//*[@id="mw-content-text"]/div/table[3]/tbody/tr[8]/td[1]

//*[@id="mw-content-text"]/div/table[3]/tbody/tr[6]/td[1]