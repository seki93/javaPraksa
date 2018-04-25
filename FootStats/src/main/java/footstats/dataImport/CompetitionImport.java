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
        String url = "http://www.livescore.com/soccer/england/";
        log.debug("navigating to the " + url);
        driver.get(url);

        try {

            int rank = 1;

            for(int i = 1; i < 11;i++) {

                if(i != 9) {

                    if (driver.findElement(By.xpath("/html/body/div[2]/div[5]/ul[4]/li[1]/ul/li[" + i + "]/a")).getText().contains("Cup")) {

                        Country england = countryService.findByName("England");

                        Competition competition = new Competition();
                        competition.setName(driver.findElement(By.xpath("/html/body/div[2]/div[5]/ul[4]/li[1]/ul/li[" + i + "]/a")).getText());
                        competition.setCountry(england);
                        competition.setRank(0);

                        competitionService.save(competition);

                    } else if(driver.findElement(By.xpath("/html/body/div[2]/div[5]/ul[4]/li[1]/ul/li[" + i + "]/a")).getText().contains("North") ||
                            driver.findElement(By.xpath("/html/body/div[2]/div[5]/ul[4]/li[1]/ul/li[" + i + "]/a")).getText().contains("South")){

                        Country england = countryService.findByName("England");

                        Competition competition = new Competition();
                        competition.setName(driver.findElement(By.xpath("/html/body/div[2]/div[5]/ul[4]/li[1]/ul/li[" + i + "]/a")).getText());
                        competition.setCountry(england);
                        competition.setRank(6);

                        competitionService.save(competition);
                    } else {

                        Country england = countryService.findByName("England");

                        Competition competition = new Competition();
                        competition.setName(driver.findElement(By.xpath("/html/body/div[2]/div[5]/ul[4]/li[1]/ul/li[" + i + "]/a")).getText());
                        competition.setCountry(england);
                        competition.setRank(rank);
                        rank++;
                        competitionService.save(competition);
                    }
                }
            }

            String url1 = "https://en.wikipedia.org/wiki/List_of_association_football_competitions";
            driver.get(url1);

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

            String url2 = "https://www.flashscore.com/";
            driver.get(url2);

            if(driver.findElement(By.xpath("//*[@id=\"lmenu_98\"]/a")).getText() != null) {

                WebElement element = driver.findElement(By.xpath("//*[@id=\"lmenu_98\"]/a"));
                Actions actions = new Actions(driver);
                actions.moveToElement(element);
                actions.click();
                actions.build().perform();

                int rank4 = 1;

                for (int i = 1; i < 20; i++) {

                    if (i != 6 && !driver.findElement(By.xpath("//*[@id=\"lmenu_98\"]/ul/li[" + i + "]/a")).getText().contains("Serie D")) {

                        if (driver.findElement(By.xpath("//*[@id=\"lmenu_98\"]/ul/li[" + i + "]/a")).getText().contains("Coppa")) {

                            Country italy = countryService.findByName("Italy");

                            Competition competition = new Competition();
                            competition.setName(driver.findElement(By.xpath("//*[@id=\"lmenu_98\"]/ul/li[" + i + "]/a")).getText());
                            competition.setCountry(italy);
                            competition.setRank(0);

                            competitionService.save(competition);

                        } else if(driver.findElement(By.xpath("//*[@id=\"lmenu_98\"]/ul/li[" + i + "]/a")).getText().contains("Serie C")) {

                            Country italy = countryService.findByName("Italy");

                            Competition competition = new Competition();
                            competition.setName(driver.findElement(By.xpath("//*[@id=\"lmenu_98\"]/ul/li[" + i + "]/a")).getText());
                            competition.setCountry(italy);
                            competition.setRank(3);

                            competitionService.save(competition);
                        } else{

                            Country italy = countryService.findByName("Italy");

                            Competition competition = new Competition();
                            competition.setName(driver.findElement(By.xpath("//*[@id=\"lmenu_98\"]/ul/li[" + i + "]/a")).getText());
                            competition.setCountry(italy);
                            competition.setRank(rank4);
                            rank4++;
                            competitionService.save(competition);
                        }
                    }

                }
            }

            String url3 = "https://en.wikipedia.org/wiki/List_of_association_football_competitions";
            driver.get(url3);


            for(int i = 2;i < 8;i++) {

                if(i != 4 && i != 5) {

                    if (driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[25]/tbody/tr[" + i + "]/td[2]/a")).getText().contains("UEFA European Championship")) {

                        Country international = countryService.findByName("International");

                        Competition competition = new Competition();
                        competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[25]/tbody/tr[" + i + "]/td[2]/a")).getText());
                        competition.setCountry(international);
                        competition.setRank(20);

                        competitionService.save(competition);

                    } else if (driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[25]/tbody/tr[" + i + "]/td[2]/a")).getText().contains("UEFA Nations League")) {

                        Country international = countryService.findByName("International");

                        Competition competition = new Competition();
                        competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[25]/tbody/tr[" + i + "]/td[2]/a")).getText());
                        competition.setCountry(international);
                        competition.setRank(30);

                        competitionService.save(competition);

                    } else if (driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[25]/tbody/tr[" + i + "]/td[2]/a")).getText().contains("UEFA Champions League")) {

                        Country international = countryService.findByName("International");

                        Competition competition = new Competition();
                        competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[25]/tbody/tr[" + i + "]/td[2]/a")).getText());
                        competition.setCountry(international);
                        competition.setRank(11);

                        competitionService.save(competition);
                    } else {

                        Country international = countryService.findByName("International");

                        Competition competition = new Competition();
                        competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[25]/tbody/tr[" + i + "]/td[2]/a")).getText());
                        competition.setCountry(international);
                        competition.setRank(22);

                        competitionService.save(competition);
                    }
                }
            }

            String url4 = "https://en.wikipedia.org/wiki/FIFA#Men's_tournaments";
            driver.get(url4);

            for(int i = 2;i < 5;i++){

                if(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[4]/tbody/tr["+ i +"]/td[1]/b")).getText().contains("World")){

                    Country international = countryService.findByName("International");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[4]/tbody/tr["+ i +"]/td[1]/b")).getText());
                    competition.setCountry(international);
                    competition.setRank(10);

                    competitionService.save(competition);

                } else if(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[4]/tbody/tr["+ i +"]/td[1]/b")).getText().contains("Confederations")){

                    Country international = countryService.findByName("International");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[4]/tbody/tr["+ i +"]/td[1]/b")).getText());
                    competition.setCountry(international);
                    competition.setRank(20);

                    competitionService.save(competition);

                } else {

                    Country international = countryService.findByName("International");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[4]/tbody/tr["+ i +"]/td[1]/b")).getText());
                    competition.setCountry(international);
                    competition.setRank(40);

                    competitionService.save(competition);
                }
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



