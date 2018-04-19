//package footstats.dataImport;
//
//import footstats.model.Competition;
//import footstats.model.Country;
//import footstats.model.Rank;
//import footstats.service.CountryService;
//import footstats.service.RankService;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//
//import static footstats.dataImport.CityImport.ENG_CODE;
//
//@Service
//public class CompetitionImport {
//
//    final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SekiSelenijum.class);
//
//    private ArrayList<String> englandCompetitions = new ArrayList<>();
//    private ArrayList<String> germanyCompetitions = new ArrayList<>();
//    private ArrayList<String> italyCompetitions = new ArrayList<>();
//    private ArrayList<String> spainCompetitions = new ArrayList<>();
//    private ArrayList<String> franceCompetitions = new ArrayList<>();
//    private ArrayList<String> serbiaCompetitions = new ArrayList<>();
//    private ArrayList<String> internationalCompetitions = new ArrayList<>();
//
//    private ArrayList<Integer> ranks = new ArrayList<>();
//
//    private int id, idEngland, idGermany, idItaly, idSpain, idFrance, idSerbia, idInternational;
//
//    private int firstRank, secondRank, thirdRank, fourthRank, fifthRank;
//
//    @Autowired
//    CountryService countryService;
//
//    @Autowired
//    RankService rankService;
//
//    @Test
//    public void importCompetitions() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        log.debug("Opening browser");
//        driver.manage().window().maximize();
//        String url = "https://en.wikipedia.org/wiki/List_of_association_football_competitions";
//        log.debug("navigating to the " + url);
//        driver.get(url);
//
//        Actions actions = new Actions(driver);
//
//        for(int i = 2; i < 7;i++) {
//
//            englandCompetitions.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr["+ i +"]/td[1]/a")).getText());
//        }
//
//        for(int i = 2;i < 7;i++){
//
//            germanyCompetitions.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[42]/tbody/tr["+ i +"]/td[2]/a")).getText());
//        }
//
//        for(int i = 1;i < 3;i++ ){
//
//            italyCompetitions.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/ul[146]/li/ul/li[1]/ul/li["+ i +"]/a")).getText());
//
//        }
//
//        for(int i = 2;i < 3;i++ ){
//
//            italyCompetitions.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/ul[146]/li/ul/li[2]/a")).getText());
//            italyCompetitions.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/ul[146]/li/ul/li[3]/ul/li/a")).getText());
//
//        }
//
//        for(int i = 2;i < 7;i++ ){
//
//            spainCompetitions.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[50]/tbody/tr["+ i +"]/td[2]/a")).getText());
//
//        }
//
//        for(int i = 2;i < 7;i++ ){
//
//            franceCompetitions.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[41]/tbody/tr["+ i +"]/td[1]/a")).getText());
//        }
//
//        for(int i = 2;i < 5;i++ ){
//
//            serbiaCompetitions.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[49]/tbody/tr["+ i +"]/td[2]/a")).getText());
//
//        }
//
//        log.debug("Closing browser");
//        driver.close();
//        driver.quit();
//
//        try {
//
//            for(int i = 0;i < englandCompetitions.size();i++){
//
//                Country england = countryService.findByName(ENG_CODE);
//                Rank rank = rankService.findByName();
//                Competition competition = new Competition();
//                competition.setName(englandCompetitions.get(i));
//                competition.setCountry(england);
//                competition.setRank(rank);
//
//
//
//
//            }
//
//            for(int i = 0;i < germanyCompetitions.size();i++){
//
//
//
//
//            }
//
//            for(int i = 0;i < italyCompetitions.size();i++){
//
//                preparedStmt1.setString(1, "" + italyCompetitions.get(i));
//                preparedStmt1.setInt(2, idItaly);
//                preparedStmt1.setInt(3, ranks.get(i));
//
//                preparedStmt1.execute();
//            }
//
//            for(int i = 0;i < spainCompetitions.size();i++){
//
//                preparedStmt1.setString(1, "" + spainCompetitions.get(i));
//                preparedStmt1.setInt(2, idSpain);
//                preparedStmt1.setInt(3, ranks.get(i));
//
//                preparedStmt1.execute();
//            }
//
//            for(int i = 0;i < franceCompetitions.size();i++){
//
//                preparedStmt1.setString(1, "" + franceCompetitions.get(i));
//                preparedStmt1.setInt(2, idFrance);
//                preparedStmt1.setInt(3, ranks.get(i));
//
//                preparedStmt1.execute();
//            }
//
//            for(int i = 0;i < serbiaCompetitions.size();i++){
//
//                preparedStmt1.setString(1, "" + serbiaCompetitions.get(i));
//                preparedStmt1.setInt(2, idSerbia);
//                preparedStmt1.setInt(3, ranks.get(i));
//
//                preparedStmt1.execute();
//            }
//
//            conn.close();
//
//        } catch (Exception e) {
//            System.out.println("Got an exception!");
//            System.out.println(e.getMessage());
//        }
//    }
//}
