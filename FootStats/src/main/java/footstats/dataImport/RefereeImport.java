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

            int j = 2;


            i++;
        }

        driver.close();
        driver.quit();
    }
}

//*[@id="site"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr[2]/td[1]/a
//*[@id="site"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr[2]/td[2]
//*[@id="site"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr[2]/td[4]

//*[@id="site"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr[3]/td[1]/a


        /*int j = 2;
        while (!driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr[" + j + "]/td[1]/a")).getText().isEmpty()) {
        try {
        String fullName = driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr[" + j + "]/td[1]/a")).getText();
        String[] piecesOfFullName = fullName.split(" ");
        String firstName = piecesOfFullName[0];
        String lastName = piecesOfFullName[1];

        String dateString1 = driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr[" + j + "]/td[2]")).getText();
        String dateString = dateString1.substring(6, 10) + '-' + dateString1.substring(3, 5) + '-' + dateString1.substring(0, 2);
        LocalDate dateOfBirth = LocalDate.parse(dateString);
        if (dateOfBirth.getYear() < 1970) {
        j++;
        continue;
        }
        Date date = Date.from(dateOfBirth.atStartOfDay(ZoneId.systemDefault()).toInstant());

        String countryName = driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr[" + j + "]/td[4]")).getText();
        Country countryOfBirth = countryService.findByName(countryName);

        Referee referee = new Referee();
        referee.setFirstName(firstName);
        referee.setLastName(lastName);
        referee.setDateOfBirth(date);
        referee.setCountryOfBirth(countryOfBirth);

        System.out.println("\n\n" + firstName + lastName + date.toString() + countryName + "\n\n");

        refereeService.save(referee);

        j++;
        } catch (DateTimeException e) {
        j++;
        continue;
        } catch (StringIndexOutOfBoundsException e) {
        j++;
        continue;
        }
        */


//*[@id="navi"]/div[4]/div[1]/div/ul[6]/li[2]/a
//*[@id="navi"]/div[4]/div[1]/div/ul[6]/li[3]/a