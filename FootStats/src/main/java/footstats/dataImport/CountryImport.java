package footstats.dataImport;

import footstats.model.Country;
import footstats.service.CountryService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CountryImport {

    @Autowired
    CountryService countryService;
    final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(CountryImport.class);

    public void importCountries() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        String url = "https://en.wikipedia.org/wiki/List_of_FIFA_country_codes";
        driver.navigate().to(url);

        Country countryInt = new Country();
        countryInt.setName("International");
        countryInt.setCountryCode("INT");
        countryService.save(countryInt);

        int i = 2;
        int j = 1;

        while (j < 5) {
            while(!driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr/td[" + j + "]/table/tbody/tr[" + i + "]/td[1]/span/a")).isEmpty()) {
                Country country = new Country();
                String countryName = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr/td[" + j + "]/table/tbody/tr[" + i + "]/td[1]/span/a")).getText();
                String countryCode = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr/td[" + j + "]/table/tbody/tr[" + i + "]/td[2]")).getText();
                country.setName(countryName);
                country.setCountryCode(countryCode);
                countryService.save(country);
                i++;
            }
            i = 2;
            j++;
        }
        driver.close();
        driver.quit();

    }
}
