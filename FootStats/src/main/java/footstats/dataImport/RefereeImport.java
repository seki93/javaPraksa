//package footstats.dataImport;
//
//import footstats.model.Country;
//import footstats.model.Referee;
//import footstats.service.CountryService;
//import footstats.service.RefereeService;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.sql.Date;
//
//@Service
//public class RefereeImport {
//
//    final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SekiSelenijum.class);
//    @Autowired
//    RefereeService refereeService;
//    @Autowired
//    CountryService countryService;
//
//    public void importReferees() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
//        String url = "http://www.worldfootball.net/referees/eng-premier-league-2017-2018/1/";
//        driver.navigate().to(url);
//
//        int j=2;
//        while(!driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr["+j+"]/td[1]/a")).getText().isEmpty()) {
//            String fullName = driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr["+j+"]/td[1]/a")).getText();
//            String[] piecesOfFullName = fullName.split(" ");
//            String firstName = piecesOfFullName[0];
//            String lastName = piecesOfFullName[1];
//
//            String dateString = driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr["+j+"]/td[2]")).getText();
//            String date = dateString.substring(6, 10) + '-' + dateString.substring(3, 5) + '-' + dateString.substring(0, 2);
//            Date dateOfBirth = Date.valueOf(date);
//
//            String countryName = driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr["+j+"]/td[4]")).getText();
//            Country countryOfBirth = countryService.findByName(countryName);
//
//            Referee referee = new Referee();
//            referee.setFirstName(firstName);
//            referee.setLastName(lastName);
//            referee.setDateOfBirth(dateOfBirth);
//            referee.setCountryOfBirth(countryOfBirth);
//
//            refereeService.save(referee);
//
//            j++;
//        }
//
//        driver.close();
//        driver.quit();
//    }
//}
//
////*[@id="site"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr[2]/td[1]/a
//
////*[@id="site"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr[2]/td[1]/a
////*[@id="site"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr[3]/td[1]/a
////*[@id="site"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr[2]/td[4]