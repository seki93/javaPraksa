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

        for(int i = 1; i <= 12; i++){
            driver.get("http://www.worldfootball.net/players_list/eng-premier-league-2017-2018/nach-name/"+i+"/");

            Document doc = null;

            try {
                doc = Jsoup.connect("http://www.worldfootball.net/players_list/eng-premier-league-2017-2018/nach-name/\"+i+\"/").get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            for(int j = 3; j <= 52; j++){
                action.moveToElement(((ChromeDriver) driver).findElementByCssSelector("#site > div.white > div.content > div > div.box > div > table > tbody > tr:nth-child("+j+") > td:nth-child(1) > a"));
                action.doubleClick().build().perform();

                Element table = doc.select("table[class=standard_tabelle yellow]").first();

                Iterator<Element> ite = table.select("td[width=65]").iterator();
                ite.next(); // first one is image, skip it

                System.out.println("Value 1: " + ite.next().text());
                System.out.println("Value 2: " + ite.next().text());
                System.out.println("Value 3: " + ite.next().text());
                System.out.println("Value 4: " + ite.next().text());
                System.out.println(table.text());
                //String txtDate = txtDateInput.attr("value");
                for(Element row: table.select("tr")){
                    Elements tds = table.select("td");
                    Elements head = table.select("th");

                    System.out.println(row.text());
                    System.out.println(head.text());
                }
                //standard_tabelle yellow
                final Elements elements = doc.select("tr:matches(Scoring) ~ tr.light");
                System.out.println();



                driver.navigate().back();
                Thread.sleep(2000);
            }

        }




        driver.close();
        driver.quit();
    }
}
