package footstats.dataImport;

import footstats.service.ClubService;
import footstats.service.CountryService;
import footstats.service.PersonService;
import footstats.service.PositionService;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;


@Service
public class PlayerImport {

    @Autowired
    PersonService personService;
    @Autowired
    ClubService clubService;
    @Autowired
    CountryService countryService;
    @Autowired
    PositionService positionService;

    public void importPlayer() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        String url = "http://www.worldfootball.net/";

        driver.get(url);

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("top_menu_item_1")));
        action.build().perform();
        action.doubleClick().build().perform();


        action.moveToElement(((ChromeDriver) driver).findElementByCssSelector("#navi > div.sitenavi > div.navibox2 > div > ul:nth-child(3) > li:nth-child(2) > a"));
        action.build().perform();
        action.doubleClick().build().perform();

        int igraca = 0;

        for(int i = 1; i <= 12; i++){
            driver.get("http://www.worldfootball.net/players_list/eng-premier-league-2017-2018/nach-name/"+i+"/");

            for(int j = 2; j < 52; j++){
                action.moveToElement(((ChromeDriver) driver).findElementByCssSelector("#site > div.white > div.content > div > div.box > div > table > tbody > tr:nth-child("+j+") > td:nth-child(1) > a"));
                action.doubleClick().build().perform();

                if(i == 1 && j == 2){
                    String fullName = driver.findElement(By.xpath("//*[@id=\"navi\"]/div[3]/h1")).getText();
                    System.out.println("Name: "+fullName);
                    ++igraca;
                    String clubName = driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[2]/td[2]/a/b")).getText();
                    System.out.println("Igra za: "+clubName);
                    System.out.println("Trenutan broj igraca: "+igraca);
                    System.out.println();

                    String text = driver.findElement(By.cssSelector("#site > div.white > div.sidebar > div:nth-child(1) > div:nth-child(4) > table")).getText();
                }else{
                    String fullName = driver.findElement(By.xpath("//*[@id=\"navi\"]/div[3]/h1")).getText();
                    System.out.println("Name: "+fullName);
                    ++igraca;

                    String clubName = driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div[1]/div[3]/div[2]/table/tbody/tr[1]/td[2]/a/b")).getText();
                    System.out.println("Igra za: "+clubName);
                    System.out.println("Trenutan broj igraca: "+igraca);
                    System.out.println();

                    String text = driver.findElement(By.cssSelector("#site > div.white > div.sidebar > div:nth-child(1) > div:nth-child(4) > table")).getText();
                }

                driver.navigate().back();
            }

        }




        driver.close();
        driver.quit();
    }
}
