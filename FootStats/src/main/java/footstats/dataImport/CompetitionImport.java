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

    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private CountryService countryService;


    public void importCompetitions() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {

            // ENGLAND COMPETITIONS

            String url = "https://www.soccer24.com/";
            driver.get(url);

            Thread.sleep(4000);

            if (driver.findElement(By.xpath("//*[@id=\"lmenu_198\"]/a")).getText() != null) {

                WebElement element = driver.findElement(By.xpath("//*[@id=\"lmenu_198\"]/a"));
                Actions actions = new Actions(driver);
                actions.moveToElement(element);
                actions.click();
                actions.build().perform();

                int rank = 1;

                Thread.sleep(3000);

                for (int i = 1; i < 5; i++) {

                    Country england = countryService.findByName("England");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"lmenu_198\"]/ul/li[" + i + "]/a")).getText());
                    competition.setCountry(england);
                    competition.setRank(rank);
                    rank++;
                    competitionService.save(competition);
                }
            }

            String url1 = "https://en.wikipedia.org/wiki/List_of_association_football_competitions";
            driver.get(url1);

            Thread.sleep(4000);

            int rank1 = 5;

            for (int i = 1; i < 4; i++) {

                if (driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr[6]/td[3]/a[" + i + "]")).getText().contains("North") ||
                        driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr[6]/td[3]/a[" + i + "]")).getText().contains("South")) {

                    Country england = countryService.findByName("England");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr[6]/td[3]/a[" + i + "]")).getText());
                    competition.setCountry(england);
                    competition.setRank(6);
                    competitionService.save(competition);

                } else {

                    Country england = countryService.findByName("England");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr[6]/td[3]/a[" + i + "]")).getText());
                    competition.setCountry(england);
                    competition.setRank(rank1);
                    rank1++;
                    competitionService.save(competition);
                }

            }

            for (int i = 10; i < 12; i++) {

                Country england = countryService.findByName("England");

                Competition competition = new Competition();
                competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr[" + i + "]/td[1]/a")).getText());
                competition.setCountry(england);
                competition.setRank(0);
                competitionService.save(competition);
            }

            // GERMANY COMPETITIONS

            String url2 = "https://www.soccer24.com/";
            driver.get(url2);

            Thread.sleep(4000);

            if (driver.findElement(By.xpath("//*[@id=\"lmenu_81\"]/a")).getText() != null) {

                WebElement element1 = driver.findElement(By.xpath("//*[@id=\"lmenu_81\"]/a"));
                Actions actions = new Actions(driver);
                actions.moveToElement(element1);
                actions.click();
                actions.build().perform();

                int rank2 = 1;

                Thread.sleep(3000);

                for (int i = 1; i < 9; i++) {

                    if (driver.findElement(By.xpath("//*[@id=\"lmenu_81\"]/ul/li[" + i + "]/a")).getText().contains("Regionalliga")) {

                        Country germany = countryService.findByName("Germany");

                        Competition competition = new Competition();
                        competition.setName(driver.findElement(By.xpath("//*[@id=\"lmenu_81\"]/ul/li[" + i + "]/a")).getText());
                        competition.setCountry(germany);
                        competition.setRank(4);

                        competitionService.save(competition);

                    } else {

                        Country germany = countryService.findByName("Germany");

                        Competition competition = new Competition();
                        competition.setName(driver.findElement(By.xpath("//*[@id=\"lmenu_81\"]/ul/li[" + i + "]/a")).getText());
                        competition.setCountry(germany);
                        competition.setRank(rank2);
                        rank2++;

                        competitionService.save(competition);
                    }
                }

            }

            String url3 = "https://en.wikipedia.org/wiki/List_of_association_football_competitions";
            driver.get(url3);

            Thread.sleep(4000);

            for (int i = 7; i < 9; i++) {

                Country germany = countryService.findByName("Germany");

                Competition competition = new Competition();
                competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[42]/tbody/tr[" + i + "]/td[2]/a")).getText());
                competition.setCountry(germany);
                competition.setRank(0);

                competitionService.save(competition);

            }

            // ITALY COMPETITIONS

            String url4 = "https://www.soccer24.com/";
            driver.get(url4);

            Thread.sleep(4000);

            if (driver.findElement(By.xpath("//*[@id=\"lmenu_98\"]/a")).getText() != null) {

                WebElement element1 = driver.findElement(By.xpath("//*[@id=\"lmenu_98\"]/a"));
                Actions actions = new Actions(driver);
                actions.moveToElement(element1);
                actions.click();
                actions.build().perform();

                int rank3 = 1;

                Thread.sleep(3000);

                for (int i = 1; i < 20; i++) {

                    if (i != 6 && !driver.findElement(By.xpath("//*[@id=\"lmenu_98\"]/ul/li[" + i + "]/a")).getText().contains("Serie D")) {

                        if (driver.findElement(By.xpath("//*[@id=\"lmenu_98\"]/ul/li[" + i + "]/a")).getText().contains("Coppa")) {

                            Country italy = countryService.findByName("Italy");

                            Competition competition = new Competition();
                            competition.setName(driver.findElement(By.xpath("//*[@id=\"lmenu_98\"]/ul/li[" + i + "]/a")).getText());
                            competition.setCountry(italy);
                            competition.setRank(0);

                            competitionService.save(competition);

                        } else if (driver.findElement(By.xpath("//*[@id=\"lmenu_98\"]/ul/li[" + i + "]/a")).getText().contains("Serie C")) {

                            Country italy = countryService.findByName("Italy");

                            Competition competition = new Competition();
                            competition.setName(driver.findElement(By.xpath("//*[@id=\"lmenu_98\"]/ul/li[" + i + "]/a")).getText());
                            competition.setCountry(italy);
                            competition.setRank(3);

                            competitionService.save(competition);
                        } else {

                            Country italy = countryService.findByName("Italy");

                            Competition competition = new Competition();
                            competition.setName(driver.findElement(By.xpath("//*[@id=\"lmenu_98\"]/ul/li[" + i + "]/a")).getText());
                            competition.setCountry(italy);
                            competition.setRank(rank3);
                            rank3++;
                            competitionService.save(competition);
                        }
                    }

                }
            }

            // SPAIN COMPETITIONS

            String url5 = "https://en.wikipedia.org/wiki/List_of_association_football_competitions";
            driver.get(url5);

            Thread.sleep(4000);

            int rank4 = 1;

            for (int i = 2; i < 8; i++) {

                if (i != 6) {

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
                        competition.setRank(rank4);
                        rank4++;
                        competitionService.save(competition);
                    }
                }

            }

            // FRANCE COMPETITIONS

            Thread.sleep(4000);

            int rank5 = 1;

            for (int i = 2; i < 9; i++) {

                if (driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[41]/tbody/tr[" + i + "]/td[1]/a")).getText().contains("Coupe")) {

                    Country france = countryService.findByName("France");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[41]/tbody/tr[" + i + "]/td[1]/a")).getText());
                    competition.setCountry(france);
                    competition.setRank(0);

                    competitionService.save(competition);

                } else {

                    Country france = countryService.findByName("France");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[41]/tbody/tr[" + i + "]/td[1]/a")).getText());
                    competition.setCountry(france);
                    competition.setRank(rank5);
                    rank5++;
                    competitionService.save(competition);
                }

            }

            // NETHERLANDS COMPETITIONS

            String url6 = "https://www.soccer24.com/";
            driver.get(url6);

            Thread.sleep(4000);

            if (driver.findElement(By.xpath("//*[@id=\"lmenu_139\"]/a")).getText() != null) {

                WebElement element1 = driver.findElement(By.xpath("//*[@id=\"lmenu_139\"]/a"));
                Actions actions = new Actions(driver);
                actions.moveToElement(element1);
                actions.click();
                actions.build().perform();

                int rank6 = 1;

                Thread.sleep(3000);

                for (int i = 1; i < 7; i++) {

                    if (i != 5) {

                        if (driver.findElement(By.xpath("//*[@id=\"lmenu_139\"]/ul/li["+ i +"]/a")).getText().contains("Beker")) {

                            Country netherlands = countryService.findByName("Netherlands");

                            Competition competition = new Competition();
                            competition.setName(driver.findElement(By.xpath("//*[@id=\"lmenu_139\"]/ul/li["+ i +"]/a")).getText());
                            competition.setCountry(netherlands);
                            competition.setRank(0);

                            competitionService.save(competition);

                        } else {

                            Country netherlands = countryService.findByName("Netherlands");

                            Competition competition = new Competition();
                            competition.setName(driver.findElement(By.xpath("//*[@id=\"lmenu_139\"]/ul/li["+ i +"]/a")).getText());
                            competition.setCountry(netherlands);
                            competition.setRank(rank6);
                            rank6++;
                            competitionService.save(competition);
                        }
                    }

                }
            }

            // SERBIA COMPETITIONS

            String url7 = "https://en.wikipedia.org/wiki/List_of_association_football_competitions";
            driver.get(url7);

            Thread.sleep(4000);

            int rank7 = 1;

            for (int i = 2; i < 6; i++) {

                if (driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[49]/tbody/tr["+ i +"]/td[2]/a")).getText().contains("Kup")) {

                    Country serbia = countryService.findByName("Serbia");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[49]/tbody/tr["+ i +"]/td[2]/a")).getText());
                    competition.setCountry(serbia);
                    competition.setRank(0);

                    competitionService.save(competition);

                } else {

                    Country serbia = countryService.findByName("Serbia");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[49]/tbody/tr["+ i +"]/td[2]/a")).getText());
                    competition.setCountry(serbia);
                    competition.setRank(rank7);
                    rank7++;
                    competitionService.save(competition);
                }

            }

            // PORTUGAL COMPETITIONS

            Thread.sleep(4000);

            int rank8 = 1;

            for (int i = 2; i < 11; i++) {

                if (driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[47]/tbody/tr["+ i +"]/td[2]/a")).getText().contains("Taça")) {

                    Country portugal = countryService.findByName("Portugal");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[47]/tbody/tr["+ i +"]/td[2]/a")).getText());
                    competition.setCountry(portugal);
                    competition.setRank(0);

                    competitionService.save(competition);

                } else {

                    Country portugal = countryService.findByName("Portugal");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[47]/tbody/tr["+ i +"]/td[2]/a")).getText());
                    competition.setCountry(portugal);
                    competition.setRank(rank8);
                    rank8++;
                    competitionService.save(competition);
                }

            }

            // INTERNATIONAL COMPETITIONS

            Thread.sleep(4000);

            for (int i = 2; i < 8; i++) {

                if (i != 4 && i != 5) {

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

            String url8 = "https://en.wikipedia.org/wiki/FIFA#Men's_tournaments";
            driver.get(url8);

            Thread.sleep(4000);

            for (int i = 2; i < 5; i++) {

                if (driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[4]/tbody/tr[" + i + "]/td[1]/b")).getText().contains("World")) {

                    Country international = countryService.findByName("International");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[4]/tbody/tr[" + i + "]/td[1]/b")).getText());
                    competition.setCountry(international);
                    competition.setRank(10);

                    competitionService.save(competition);

                } else if (driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[4]/tbody/tr[" + i + "]/td[1]/b")).getText().contains("Confederations")) {

                    Country international = countryService.findByName("International");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[4]/tbody/tr[" + i + "]/td[1]/b")).getText());
                    competition.setCountry(international);
                    competition.setRank(20);

                    competitionService.save(competition);

                } else {

                    Country international = countryService.findByName("International");

                    Competition competition = new Competition();
                    competition.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[4]/tbody/tr[" + i + "]/td[1]/b")).getText());
                    competition.setCountry(international);
                    competition.setRank(40);

                    competitionService.save(competition);
                }
            }
        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }

        driver.close();
        driver.quit();
    }
}



