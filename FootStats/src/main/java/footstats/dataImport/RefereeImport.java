package footstats.dataImport;

import footstats.model.Country;
import footstats.model.Referee;
import footstats.service.CountryService;
import footstats.service.RefereeService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.NoSuchElementException;

@Service
public class RefereeImport {

    final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SekiSelenijum.class);
    @Autowired
    RefereeService refereeService;
    @Autowired
    CountryService countryService;

    public void importReferees() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "http://www.worldfootball.net/";
        driver.navigate().to(url);

        Actions action = new Actions(driver);
        int i = 1;
        while(true) {
            action.moveToElement(driver.findElement(By.xpath("//*[@id=\"toggle-menu-3\"]")));
            action.click().build().perform();

            //isCountryExists?
            String country = "//*[@id=\"special_navi_body\"]/a["+i+"]";
            if(driver.findElements(By.xpath(country)).isEmpty()){
                break;
            }

            action.moveToElement(driver.findElement(By.xpath(country)));
            action.click().build().perform();

            //isrefereefieldExists?
            String refereesField = "//*[@id=\"navi\"]/div[4]/div[1]/div/ul[5]/li[3]/a";
            if(driver.findElements(By.xpath(refereesField)).isEmpty()){
                i++;
                continue;
            }

            action.moveToElement(driver.findElement(By.xpath(refereesField)));
            action.click().build().perform();

            Thread.sleep(1000);

            int j = 2;
            //nameOfReferees
            while( driver.findElements(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr["+j+"]/td[1]/a")).size() > 0 ) {

                Referee referee = new Referee();

                String fullName = driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr["+j+"]/td[1]/a")).getText();
                int indexOfSpace = fullName.indexOf(' ');
                String firstName = fullName.substring(0, indexOfSpace);
                String lastName = fullName.substring(indexOfSpace + 1);
                referee.setFirstName(firstName);
                referee.setLastName(lastName);

                Date date = null;
                if( !driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr["+j+"]/td[2]")).getText().isEmpty() ) {
                    String dateSlash = driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr[" + j + "]/td[2]")).getText();
                    String dateHyphen = dateSlash.substring(6, 10) + '-' + dateSlash.substring(3, 5) + '-' + dateSlash.substring(0, 2);
                    if(dateSlash.substring(3, 5).equals("00") || dateSlash.substring(0, 2).equals("00")){
                        break;
                    } else {
                        LocalDate dateOfBirth = LocalDate.parse(dateHyphen);
                        date = Date.from(dateOfBirth.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    }
                }
                referee.setDateOfBirth(date);

                String countryName = null;
                if( !driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr[" + j + "]/td[4]")).getText().isEmpty() ) {
                    countryName = driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr[" + j + "]/td[4]")).getText();
                }
                if(countryName.equals("USA")){
                    countryName = "United States";
                } else if(countryName.equals("Ireland")){
                    countryName = "Republic of Ireland";
                } else if (countryName.equals("China")) {
                    countryName = "China PR";
                }
                Country coutryOfBirth = countryService.findByName(countryName);
                referee.setCountryOfBirth(coutryOfBirth);

                refereeService.save(referee);

                j++;

            }

            i++;
        }

        driver.close();
        driver.quit();
    }
}