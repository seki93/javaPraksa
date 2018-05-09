package footstats.dataImport;

import footstats.model.Player;
import footstats.service.ClubService;
import footstats.service.CountryService;
import footstats.service.PersonService;
import footstats.service.PositionService;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;


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

        int i = 2;

        while(true) {
            action.moveToElement(driver.findElement(By.xpath("//*[@id=\"toggle-menu-3\"]")));
            action.build().perform();
            action.doubleClick().build().perform();

            String country = "//*[@id=\"special_navi_body\"]/a["+i+"]";
            if(driver.findElements(By.xpath(country)).isEmpty()) break;

            action.moveToElement(driver.findElement(By.xpath("//*[@id=\"special_navi_body\"]/a["+i+"]")));
            action.build().perform();
            action.doubleClick().build().perform();

            importPlayerInDatabase(driver, country);

            System.out.println("Country: "+driver.findElement(By.xpath("//*[@id=\"toggle-menu-3\"]")).getText()+" Number of country: "+i);

            ++i;
        }

        driver.close();
        driver.quit();
    }

    public void importPlayerInDatabase(WebDriver driver, String country) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"navi\"]/div[4]/div[1]/div/ul[3]/li[2]/a")));
        action.doubleClick().perform();

        System.out.println("nasao sam pleyere");
        while(true){
            int i = 51;

            while(true){
                if(driver.findElements(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr["+i+"]/td[1]/a")).size() == 0 ) break;

                action.moveToElement(driver.findElement(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[3]/div/table/tbody/tr["+i+"]/td[1]/a")));
                action.click().build().perform();


                Document doc = null;
                try {
                    doc = Jsoup.connect(driver.getCurrentUrl()).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //System.out.println(++igraca);
                Element playerFullName = doc.getElementsByClass("breadcrumb").first();
                Element clubInfo = doc.getElementsByClass("dunkel").tagName("b").first();

                //CLUB AND POSITION
                String playerInfo = clubInfo.text();
                String position = null;
                String clubname = "";
                String[] clubAndPostition = playerInfo.split(" ");
                for (int n = 0; n < clubAndPostition.length; n++){
                    if(clubAndPostition[n].equals(country)){
                        position = clubAndPostition[n+1];
                        break;
                    }
                    clubname += clubAndPostition[n]+" ";
                }

                if(clubname.endsWith(" ")) clubname = clubname.substring(0, clubname.length() -1);

                System.out.println("Club: "+clubname);
                System.out.println("Position: "+position);
                //END


                //FIRSTNAME AND SURNAME
                String fullName = playerFullName.text();
                String[] splitFullName = fullName.split(" ");
                String firstName;
                String lastName = null;
                if(splitFullName.length == 1) firstName = splitFullName[0];
                else{
                    firstName = splitFullName[0];
                    lastName = splitFullName[1];
                }

                System.out.println("First name: "+firstName);
                System.out.println("Last name: "+lastName);
                //END

                //DATE AND NATIONALITY
                String info = doc.getElementsByClass("data").text();
                int datePosition = info.indexOf("Born:");
                String date = info.substring(datePosition+6, datePosition+16);
                date.trim();

                String nationality = "";
                int nationalityPosition = info.indexOf("Nationality");
                int endOfNationalityPosition = info.indexOf("Height");
                if(endOfNationalityPosition > 0) nationality = info.substring(nationalityPosition+13, endOfNationalityPosition - 1);
                else nationality = info.substring(nationalityPosition+13, info.length());
                nationality.trim();
                System.out.println("Date: "+date);
                System.out.println("Nationality: "+nationality);
                System.out.println();
                //END

                ++i;
               driver.navigate().back();
            }
            if(driver.findElements(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[2]/div/table/tbody/tr/td[7]/a")).isEmpty()) break;

            String arrow = "//*[@id=\"site\"]/div[3]/div[1]/div/div[2]/div/table/tbody/tr/td[7]/a";
            ((JavascriptExecutor)driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");

            action.moveToElement(driver.findElement(By.xpath(arrow)));
            action.click().build().perform();
        }
        Thread.sleep(1000);

    }
}
