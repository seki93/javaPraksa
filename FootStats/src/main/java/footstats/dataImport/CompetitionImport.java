package footstats.dataImport;

import footstats.model.Competition;
import footstats.model.Country;
import footstats.service.CompetitionService;
import footstats.service.CountryService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitionImport {

    final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SekiSelenijum.class);

    @Autowired
    CompetitionService competitionService;

    @Autowired
    CountryService countryService;


    public void importCompetitions() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        log.debug("Opening browser");
        driver.manage().window().maximize();
        String url = "https://en.wikipedia.org/wiki/List_of_association_football_competitions";
        log.debug("navigating to the " + url);
        driver.get(url);

        try {
            int rank = 1;

            for(int i = 2; i < 12;i++) {

                if(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr[" + i + "]/td[1]/a")).getText().contains("Cup")){

                    Country england = countryService.findByName("England");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr[" + i + "]/td[1]/a")).getText());
                    competition.setCountry(england);
                    competition.setRank(0);

                    competitionService.save(competition);

                } else if(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr[" + i + "]/td[1]/a")).getText().contains("ern")) {

                    Country england = countryService.findByName("England");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr[" + i + "]/td[1]/a")).getText());
                    competition.setCountry(england);
                    competition.setRank(6);

                    competitionService.save(competition);

                }else {

                    Country england = countryService.findByName("England");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr[" + i + "]/td[1]/a")).getText());
                    competition.setCountry(england);
                    competition.setRank(rank);
                    rank++;
                    competitionService.save(competition);
                }

            }

            int rank1 = 1;

            for(int i = 2; i < 9;i++) {

                if(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[42]/tbody/tr["+ i +"]/td[2]/a")).getText().contains("DFB")){

                    Country germany = countryService.findByName("Germany");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[42]/tbody/tr["+ i +"]/td[2]/a")).getText());
                    competition.setCountry(germany);
                    competition.setRank(0);

                    competitionService.save(competition);

                } else {

                    Country germany = countryService.findByName("Germany");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[42]/tbody/tr["+ i +"]/td[2]/a")).getText());
                    competition.setCountry(germany);
                    competition.setRank(rank1);
                    rank1++;
                    competitionService.save(competition);
                }

            }

            int rank2 = 1;

            for(int i = 2; i < 8;i++) {

                if(i != 6) {

                    if (driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[50]/tbody/tr[" + i + "]/td[2]/a")).getText().contains("Copa")) {

                        Country spain = countryService.findByName("Spain");

                        Competition competition = new Competition();
                        competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[50]/tbody/tr[" + i + "]/td[2]/a")).getText());
                        competition.setCountry(spain);
                        competition.setRank(0);

                        competitionService.save(competition);

                    } else {

                        Country spain = countryService.findByName("Spain");

                        Competition competition = new Competition();
                        competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[50]/tbody/tr[" + i + "]/td[2]/a")).getText());
                        competition.setCountry(spain);
                        competition.setRank(rank2);
                        rank2++;
                        competitionService.save(competition);
                    }
                }

            }

            int rank3 = 1;

            for(int i = 2; i < 9;i++) {

                    if (driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[41]/tbody/tr["+ i +"]/td[1]/a")).getText().contains("Coupe")) {

                        Country france = countryService.findByName("France");

                        Competition competition = new Competition();
                        competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[41]/tbody/tr["+ i +"]/td[1]/a")).getText());
                        competition.setCountry(france);
                        competition.setRank(0);

                        competitionService.save(competition);

                    } else {

                        Country france = countryService.findByName("France");

                        Competition competition = new Competition();
                        competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[41]/tbody/tr["+ i +"]/td[1]/a")).getText());
                        competition.setCountry(france);
                        competition.setRank(rank3);
                        rank3++;
                        competitionService.save(competition);
                    }

            }

            //*[@id="mw-content-text"]/div/table[41]/tbody/tr[2]/td[1]/a
            //*[@id="mw-content-text"]/div/table[41]/tbody/tr[8]/td[1]/a

            //*[@id="mw-content-text"]/div/table[50]/tbody/tr[2]/td[2]/a
            //*[@id="mw-content-text"]/div/table[50]/tbody/tr[6]/td[2]/a

            //*[@id="mw-content-text"]/div/table[50]/tbody/tr[7]/td[2]/a


            /*int j = 2;

            while(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[42]/tbody/tr["+ j +"]/td[2]/a")).getText() != null) {

                Country germany = countryService.findByName("Germany");

                Competition competition = new Competition();
                competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[42]/tbody/tr[" + j + "]/td[2]/a")).getText());
                competition.setCountry(germany);


                competitionService.save(competition);

                j++;
            }

            int m = 2;

            while(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[50]/tbody/tr["+ m +"]/td[2]/a")).getText() != null){

                Country spain = countryService.findByName("Spain");

                Competition competition = new Competition();
                competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[50]/tbody/tr["+ m +"]/td[2]/a")).getText());
                competition.setCountry(spain);

                competitionService.save(competition);

                m++;
            }

            int n = 2;

            while(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[41]/tbody/tr["+ n +"]/td[1]/a")).getText() != null){

                Country france = countryService.findByName("France");

                Competition competition = new Competition();
                competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[41]/tbody/tr["+ n +"]/td[1]/a")).getText());
                competition.setCountry(france);

                competitionService.save(competition);

                n++;
            }

            int p = 2;

            while(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[49]/tbody/tr["+ p +"]/td[2]/a")).getText() != null){

                Country serbia = countryService.findByName("Serbia");

                Competition competition = new Competition();
                competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[49]/tbody/tr["+ p +"]/td[2]/a")).getText());
                competition.setCountry(serbia);

                competitionService.save(competition);

                p++;
            }

            String url1 = "https://en.wikipedia.org/wiki/Italian_football_league_system";
            driver.get(url1);

            int k = 3;

            while(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[3]/tbody/tr["+ k +"]/td[2]/b/a")).getText() != null){

                Country italy = countryService.findByName("Italy");

                Competition competition = new Competition();
                competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[3]/tbody/tr["+ k +"]/td[2]/b/a")).getText());
                competition.setCountry(italy);

                competitionService.save(competition);

                k++;
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


//*[@id="Ecuador"]/a