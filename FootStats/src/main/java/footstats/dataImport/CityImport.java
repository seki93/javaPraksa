package footstats.dataImport;

import footstats.model.City;
import footstats.model.Country;
import footstats.service.CityService;
import footstats.service.CountryService;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityImport {

    final static Logger log = Logger.getLogger(StadiumImport.class);
    public static final String ENGLAND = "England";
    public static final String FRANCE = "France";
    public static final String ITALY = "Italy";
    public static final String GERMANY = "Germany";
    public static final String SPAIN = "Spain";
    public static final String WALES = "Wales";

    private static String citiesString = "";

    @Autowired
    CountryService countryService;
    @Autowired
    CityService cityService;

    public void importCities() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        log.debug("Opening browser");
        driver.manage().window().maximize();

        String url = "https://simple.wikipedia.org/wiki/List_of_cities_and_towns_in_England";
        importEnglandCities(driver, url);

        url = "https://en.wikipedia.org/wiki/List_of_cities_in_Italy";
        importItalyCities(driver, url);

        url = "https://population.mongabay.com/population/spain/";
        importSpainCities(driver, url);

        url = "https://en.wikipedia.org/wiki/List_of_cities_and_towns_in_Germany";
        importGermanCities(driver, url);

        url = "https://simple.wikipedia.org/wiki/List_of_cities_in_France";
        importFranceCities(driver, url);

        url = "https://en.wikipedia.org/wiki/List_of_towns_in_Wales";
        importWelsCities(driver, url);

        driver.close();
        driver.quit();
    }

    public void importEnglandCities(WebDriver driver, String url){
        driver.get(url);

        for(int i = 3; i <= 26; i++){
            String count = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/p["+i+"]")).getText();
            citiesString+= count+", ";
        }

        Country england = countryService.findByName(ENGLAND);
        String[] parts = citiesString.split(",");
        for(int i = 0; i < parts.length; i++){
            City c = new City();
            c.setName(parts[i].trim());
            c.setCountry(england);

            if(cityService.findByName(c.getName()) == null) cityService.save(c);
        }
        citiesString = "";
    }

    public void importItalyCities(WebDriver driver, String url){
        driver.get(url);

        Country italy = countryService.findByName(ITALY);
        for(int i = 1; i <= 144; i++){
            City c = new City();
            c.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr["+i+"]/td[2]")).getText());
            c.setCountry(italy);

            if(cityService.findByName(c.getName()) == null) cityService.save(c);
        }
    }

    public void importSpainCities(WebDriver driver, String url){
        driver.get(url);

        Country spain = countryService.findByName(SPAIN);
        for(int i = 1; i <=  569; i++){
            City c = new City();
            c.setName(driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr["+i+"]/td[1]/a")).getText());
            c.setCountry(spain);

            if(cityService.findByName(c.getName()) == null) cityService.save(c);
        }
    }

    public void importGermanCities(WebDriver driver, String url){
        driver.get(url);

        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[25]/tbody/td"));

        Country germany = countryService.findByName(GERMANY);
        for(int i = 1; i <= 25; i++){
            for(int j = 1; j <=3 ; j++){
                rows = driver.findElements(By.xpath(" //*[@id=\"mw-content-text\"]/div/table["+i+"]/tbody/tr[2]/td["+j+"]/ul/li"));
                for(int k = 1; k<= rows.size(); k++){
                    City c = new City();
                    c.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table["+i+"]/tbody/tr[2]/td["+j+"]/ul/li["+k+"]/a")).getText());
                    c.setCountry(germany);

                    if(cityService.findByName(c.getName()) == null) cityService.save(c);
                }
            }
        }
    }

    public void importFranceCities(WebDriver driver, String url){
        driver.get(url);

        Country france = countryService.findByName(FRANCE);
        for(int i = 1; i <= 434; i++){
            City c = new City();
            c.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table/tbody/tr["+i+"]/td[1]")).getText());
            c.setCountry(france);

            if(cityService.findByName(c.getName()) == null) cityService.save(c);
        }
    }

    public void importWelsCities(WebDriver driver, String url){
        driver.get(url);

        Country wales = countryService.findByName(WALES);
        for(int i = 3; i <= 23; i++){
            String count = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/p["+i+"]")).getText();
            citiesString+= count+", ";
        }
        String[] parts1 = citiesString.split(",");
        for(int i = 0; i < parts1.length; i++){
            City c = new City();
            c.setName(parts1[i].trim());
            c.setCountry(wales);

            if(cityService.findByName(c.getName()) == null) cityService.save(c);
        }
        citiesString = "";
    }

}
