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
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

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

        String url = "https://www.soccer24.com/africa/africa-cup-of-nations/";
        importNationalTeams(driver, url);

        driver.close();
        driver.quit();

    }

    private void importNationalTeams(WebDriver driver, String url) throws InterruptedException {
        driver.get(url);

        Thread.sleep(3000);

        Actions action = new Actions(driver);

        if (!driver.findElements(By.xpath("//*[@id=\"mt\"]/li[1]/a")).isEmpty()) {

            for (int i = 1; i < 11; i++) {

                if (i != 2 && i != 3 && i != 4 && i != 5 && i != 8 && i != 9) {

                    action.moveToElement(driver.findElement(By.xpath("//*[@id=\"mt\"]/li[" + i + "]/a")));
                    action.click().build().perform();
                    Thread.sleep(1000);

                    int k = 1;

                    while (!driver.findElements(By.xpath("//*[@id=\"table-type-1\"]/tbody[" + k + "]/tr[1]/td[2]/span[2]/a")).isEmpty()) {

                        int j = 1;
                        while (!driver.findElements(By.xpath("//*[@id=\"table-type-1\"]/tbody[" + k + "]/tr[" + j + "]/td[2]/span[2]/a")).isEmpty()) {

                            String countryName = driver.findElement(By.xpath("//*[@id=\"table-type-1\"]/tbody[" + k + "]/tr[" + j + "]/td[2]/span[2]/a")).getText();
                            Country country;
                            if (countryService.findByName(countryName) == null) {
                                country = new Country();
                                country.setName(countryName);
                                countryService.save(country);
                            } else {
                                country = countryService.findByName(countryName);
                            }

                            String nationalTeamName = driver.findElement(By.xpath("//*[@id=\"table-type-1\"]/tbody[" + k + "]/tr[" + j + "]/td[2]/span[2]/a")).getText();

                            System.out.println("Nasao sam ovaj nacionalni tim: ");
                            System.out.println(nationalTeamName);

                            NationalTeam nationalTeam;
                            if (nationalTeamService.findByName(nationalTeamName) == null) {
                                nationalTeam = new NationalTeam();
                                nationalTeam.setName(nationalTeamName);
                                nationalTeam.setCountry(country);
                                nationalTeamService.save(nationalTeam);
                            } else {
                                nationalTeam = nationalTeamService.findByName(nationalTeamName);
                            }
                            System.out.println("A ovo sam nasao u bazi: ");
                            System.out.println(nationalTeam.getName());

                            String competitionName = driver.findElement(By.xpath("//*[@id=\"fscon\"]/div[1]/div[2]")).getText();

                            System.out.println("Competiton name: ");
                            System.out.println(competitionName);

                            Competition competition = competitionService.findByName(competitionName);

                            System.out.println("Ovo sam nasao u bazi: ");
                            System.out.println(competition.getName());
                            System.out.println();

                            nationalTeam.setCompetitions(new HashSet<>());
                            nationalTeam.getCompetitions().add(competition);
                            System.out.println(nationalTeam.getCompetitions().size());
                            //nationalTeam.addCompetition(competition);

                            nationalTeamService.save(nationalTeam);

                            j++;
                        }

                        k++;

                    }
                }
            }
        }
    }
}


//
//            int j = 1;
//            while (true) {
//                action.moveToElement(driver.findElement(By.xpath(path)));
//                action.click().build().perform();
//                Thread.sleep(1000);
//
//                String leaguePath = "//*[@id=\"lmenu_" + i + "\"]/ul/li[" + j + "]/a";
//                if (driver.findElements(By.xpath(leaguePath)).isEmpty()) {
//                    break;
//                }
//
//                action.moveToElement(driver.findElement(By.xpath(leaguePath)));
//                action.click().build().perform();
//                Thread.sleep(1000);
//
//                if (driver.findElement(By.xpath("//*[@id=\"lmenu_" + i + "\"]/ul/li[" + j + "]/a")).getText().contains("World Cup")) {
//                    j++;
//                    continue;
//                }
//
//                String countryName = driver.findElement(By.xpath("//*[@id=\"table-type-1\"]/tbody["+ i +"]/tr["+ j +"]/td[2]/span[2]/a")).getText();
//                Country country = countryService.findByName(countryName);
//
//                String nationalTeamName = driver.findElement(By.xpath("//*[@id=\"table-type-1\"]/tbody["+ i +"]/tr["+ j +"]/td[2]/span[2]/a")).getText();
//
//                String competitionName = driver.findElement(By.xpath("//*[@id=\"lmenu_" + i + "\"]/ul/li[" + j + "]/a")).getText();
//
//                Competition competition;
//                if (competitionService.findByName(competitionName) == null) {
//                    competition = new Competition();
//                    competition.setName(competitionName);
//                    competitionService.save(competition);
//                } else {
//                    competition = competitionService.findByName(competitionName);
//                }
//
//                NationalTeam nationalTeam = new NationalTeam();
//                nationalTeam.setName(nationalTeamName);
//                nationalTeam.setCountry(country);
//                nationalTeam.setCompetitions(new HashSet<>());
//                nationalTeam.addCompetition(competition);
//
//                nationalTeamService.save(nationalTeam);
//
//                j++;
//
//            }
//
//            i++;
//

// driver.findElements(By.xpath("//*[@id=\"participant_4M0iRO5p\"]/td/a"))

//        url = "https://en.wikipedia.org/wiki/2017_FIFA_Confederations_Cup";
//        importConfederationsCupNationalTeams(driver, url);
//
//        url = "https://en.wikipedia.org/wiki/UEFA_Euro_2016";
//        importEuropeanChampionShipNationalTeams(driver, url);
//
//
//        driver.close();
//        driver.quit();
//    }
//
//    private void importWorldCupNationalTeams(WebDriver driver, String url) throws InterruptedException {
//        driver.get(url);
//
//        Thread.sleep(3000);
//
//        int i = 1;
//
//        while (!driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[" + i + "]/td[1]/span/a")).isEmpty()) {
//
//            Competition international = competitionService.findByName("World Cup");
//
//            Country country = countryService.findByName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[" + i + "]/td[1]/span/a")).getText());
//
//            NationalTeam nationalTeam = new NationalTeam();
//            nationalTeam.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[" + i + "]/td[1]/span/a")).getText());
//            nationalTeam.setCompetition(international);
//            nationalTeam.setCountry(country);
//            nationalTeamService.save(nationalTeam);
//
//            i++;
//        }
//    }
//
//    private void importConfederationsCupNationalTeams(WebDriver driver, String url) throws  InterruptedException {
//        driver.get(url);
//
//        Thread.sleep(3000);
//
//        int i = 1;
//
//        while (!driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[" + i + "]/td[1]/span/a")).isEmpty()) {
//
//            Competition international = competitionService.findByName("Confederations Cup");
//
//            Country country = countryService.findByName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[" + i + "]/td[1]/span/a")).getText());
//
//            NationalTeam nationalTeam = new NationalTeam();
//            nationalTeam.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr[" + i + "]/td[1]/span/a")).getText());
//            nationalTeam.setCompetition(international);
//            nationalTeam.setCountry(country);
//            nationalTeamService.save(nationalTeam);
//
//            i++;
//        }
//    }
//
//    private void importEuropeanChampionShipNationalTeams(WebDriver driver, String url) throws InterruptedException {
//        driver.get(url);
//
//        Thread.sleep(3000);
//
//        int i = 1;
//
//        while (!driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[3]/tbody/tr["+ i +"]/td[1]/span/a")).isEmpty()) {
//
//            Competition international = competitionService.findByName("UEFA European Championship");
//
//            Country country = countryService.findByName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[3]/tbody/tr["+ i +"]/td[1]/span/a")).getText());
//
//            NationalTeam nationalTeam = new NationalTeam();
//            nationalTeam.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[3]/tbody/tr["+ i +"]/td[1]/span/a")).getText());
//            nationalTeam.setCompetition(international);
//            nationalTeam.setCountry(country);
//            nationalTeamService.save(nationalTeam);
//
//            i++;
//        }


//*[@id="mt"]/li[1]/a// *[@id="table-type-1"]/tbody[1]/tr[1]/td[2]/span[2]/a
//*[@id="lmenu_1"]/ul/li[1]/a
//*[@id="mt"]/li[6]/a                 //*[@id="table-type-1"]/tbody[12]/tr[4]/td[2]/span[2]/a

//*[@id="mt"]/li[7]/a

//*[@id="mt"]/li[8]/a

//*[@id="mt"]/li[9]/a

//*[@id="mt"]/li[10]/a

//*[@id="lmenu_1"]/ul/li[1]/a
//*[@id="lmenu_1"]/ul/li[14]/a


