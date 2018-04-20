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

import java.util.ArrayList;
import java.util.List;

@Service
public class CityImport {

    final static Logger log = Logger.getLogger(StadiumImport.class);
    public static final String ENG_CODE = "England";
    public static final String FRN_CODE = "France";
    public static final String ITL_CODE = "Italy";
    public static final String GER_CODE = "Germany";
    public static final String SPA_CODE = "Spain";

    private ArrayList<String> englandCities = new ArrayList<String>();
    private ArrayList<String> italyCities = new ArrayList<String>();
    private ArrayList<String> spainCities = new ArrayList<String>();
    private ArrayList<String> germanyCities = new ArrayList<String>();
    private ArrayList<String> franceCities = new ArrayList<String>();
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

        //ENGLAND CITIES
        String url = "https://simple.wikipedia.org/wiki/List_of_cities_and_towns_in_England";
        driver.get(url);

        for(int i = 3; i <= 26; i++){
            String count = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/p["+i+"]")).getText();
            citiesString+= count+", ";
        }

        Country england = countryService.findByName(ENG_CODE);
        String[] parts = citiesString.split(",");
        for(int i = 0; i < parts.length; i++){
            City c = new City();
            c.setName(parts[i].trim());
            c.setCountry(england);
            cityService.save(c);
        }

        //ITALY CITIES
        String url2 = "https://en.wikipedia.org/wiki/List_of_cities_in_Italy";
        driver.get(url2);
        citiesString = "";
        Country italy = countryService.findByName(ITL_CODE);
        for(int i = 1; i <= 144; i++){
            City c = new City();
            c.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr["+i+"]/td[2]")).getText());
            c.setCountry(italy);
            cityService.save(c);
        }

        //SPAIN CITIES
        String url3 = "https://population.mongabay.com/population/spain/";
        driver.get(url3);

        Country spain = countryService.findByName(SPA_CODE);
        for(int i = 1; i <=  569; i++){
            City c = new City();
            c.setName(driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr["+i+"]/td[1]/a")).getText());
            c.setCountry(spain);
            cityService.save(c);
        }

        //GERMANY CITIES
        String url4 = "https://en.wikipedia.org/wiki/List_of_cities_and_towns_in_Germany";
        driver.get(url4);

        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[25]/tbody/td"));
        rows = driver.findElements(By.xpath(" //*[@id=\"mw-content-text\"]/div/table[25]/tbody/tr[2]/td[1]/ul/li"));

        Country germany = countryService.findByName(GER_CODE);
        for(int i = 1; i <= 25; i++){
            for(int j = 1; j <=3 ; j++){
                rows = driver.findElements(By.xpath(" //*[@id=\"mw-content-text\"]/div/table["+i+"]/tbody/tr[2]/td["+j+"]/ul/li"));
                for(int k = 1; k<= rows.size(); k++){
                    City c = new City();
                    c.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table["+i+"]/tbody/tr[2]/td["+j+"]/ul/li["+k+"]/a")).getText());
                    c.setCountry(germany);
                    cityService.save(c);
                }
            }
        }

        //FRANCE CITIES
        String url5 = "https://simple.wikipedia.org/wiki/List_of_cities_in_France";
        driver.get(url5);

        Country france = countryService.findByName(FRN_CODE);
        for(int i = 1; i <= 434; i++){
            City c = new City();
            c.setName(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table/tbody/tr["+i+"]/td[1]")).getText());
            c.setCountry(france);
            cityService.save(c);
        }

        driver.close();
        driver.quit();

//        try {
//            Country england = countryService.findByName(ENG_CODE);
//            for(String s: englandCities){
//                City c = new City();
//                c.setName(s);
//                c.setCountry(england);
//                cityService.save(c);
//            }
//
//            Country italy = countryService.findByName(ITL_CODE);
//            for(String s: italyCities){
//                City c = new City();
//                c.setName(s);
//                c.setCountry(italy);
//                cityService.save(c);
//            }
//
//            Country germany = countryService.findByName(GER_CODE);
//            for(String s: germanyCities){
//                City c = new City();
//                c.setName(s);
//                c.setCountry(germany);
//                cityService.save(c);
//            }
//
//            Country spain = countryService.findByName(SPA_CODE);
//            for(String s: spainCities){
//                City c = new City();
//                c.setName(s);
//                c.setCountry(spain);
//                cityService.save(c);
//            }
//
//            Country france = countryService.findByName(FRN_CODE);
//            for(String s: franceCities){
//                City c = new City();
//                c.setName(s);
//                c.setCountry(france);
//                cityService.save(c);
//            }
//
//        } catch (Exception e) {
//            log.debug("Got an exception!");
//            log.debug(e.getMessage());
//        }

    }

}
