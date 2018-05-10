package footstats.dataImport;

import footstats.model.*;
import footstats.service.*;
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
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
    @Autowired
    NationalTeamService nationalTeamService;
    @Autowired
    PlayerService playerService;

    public void importPlayer() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        String url = "http://www.worldfootball.net/";

        driver.get(url);

        Actions action = new Actions(driver);

        int i = 2;
        int brojIgraca = 1;

        while(true) {
            action.moveToElement(driver.findElement(By.xpath("//*[@id=\"toggle-menu-3\"]")));
            action.build().perform();
            action.doubleClick().build().perform();

            String country = "//*[@id=\"special_navi_body\"]/a["+i+"]";
            if(driver.findElements(By.xpath(country)).isEmpty()) break;

            String countryName = driver.findElement(By.xpath("//*[@id=\"special_navi_body\"]/a["+i+"]")).getText();
            action.moveToElement(driver.findElement(By.xpath("//*[@id=\"special_navi_body\"]/a["+i+"]")));
            action.build().perform();
            action.doubleClick().build().perform();

            importPlayerInDatabase(driver, countryName);

            System.out.println("Country: "+driver.findElement(By.xpath("//*[@id=\"toggle-menu-3\"]")).getText()+" Number of country: "+i);

            ++i;
        }

        driver.close();
        driver.quit();
    }

    public void importPlayerInDatabase(WebDriver driver, String countryName) throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"navi\"]/div[4]/div[1]/div/ul[3]/li[2]/a")));
        action.doubleClick().perform();

        while(true){
            int i = 2;

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

                Element playerFullName = doc.getElementsByClass("breadcrumb").first();
                Element clubInfo = doc.getElementsByClass("dunkel").tagName("b").first();

                //CLUB AND POSITION
                String playerInfo = clubInfo.text();
                String position = null;
                String clubname = "";
                String[] clubAndPostition = playerInfo.split(" ");
                for (int n = 0; n < clubAndPostition.length; n++){
                    if(clubAndPostition[n].equals(countryName)){
                        position = clubAndPostition[n+1];
                        break;
                    }
                    clubname += clubAndPostition[n]+" ";
                }

                if(clubname.endsWith(" ")) clubname = clubname.substring(0, clubname.length() -1);
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
                //END

                //DATE AND NATIONALITY
                String info = doc.getElementsByClass("data").text();
                String date = "";
                if(info.contains("???")){
                    int datePosition = info.indexOf("Born:");
                    date = info.substring(datePosition+6, datePosition+16);
                    date.trim();
                }else{
                    date = "???";
                }


                String nationality = "";
                int nationalityPosition = info.indexOf("Nationality");
                int endOfNationalityPosition = info.indexOf("Height");
                if(endOfNationalityPosition > 0) nationality = info.substring(nationalityPosition+13, endOfNationalityPosition - 1);
                else nationality = info.substring(nationalityPosition+13, info.length());
                nationality.trim();
                //END
                Player player = new Player();

                player.setFirstName(firstName);
                player.setLastName(lastName);

                Country country = countryService.findByName(nationality);

                if(country == null){
                    Country country1 = new Country();
                    country1.setName(nationality);
                    countryService.save(country1);
                }

                List<NationalTeam> nationalTeam = nationalTeamService.findNationalTeamByName(nationality);

                if(nationalTeam.size() == 0 || nationalTeam == null){
                    NationalTeam nationalTeam1 = new NationalTeam();
                    nationalTeam1.setName(nationality);
                    nationalTeam1.setCountry(country);
                    nationalTeamService.save(nationalTeam1);

                    player.setNationalTeam(nationalTeam1);
                }else{
                    player.setNationalTeam(nationalTeam.get(0));
                }

                Club c = clubService.findByName(clubname);
                if(c == null){
                    Club club = new Club();
                    club.setName(clubname);
                    clubService.save(club);

                    player.setClub(club);
                }else{
                    player.setClub(c);
                }

                Position position1 = positionService.findByName(position);

                if(position1 == null) {
                    Position position2 = new Position();
                    position2.setName(position);
                    positionService.save(position2);

                    player.setPosition(position2);
                }else{
                    player.setPosition(position1);
                }

                //07.10.1996
                Date date1 = null;
                if(date.equals("???")){
                    player.setDateOfBirth(date1);
                }else{
                    String dateHyphen = date.substring(6, 10) + '-' + date.substring(3, 5) + '-' + date.substring(0, 2);

                    LocalDate dateOfBirth = LocalDate.parse(dateHyphen);
                    date1 = Date.from(dateOfBirth.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    player.setDateOfBirth(date1);
                }

                playerService.save(player);
//                System.out.println("Club: "+clubname);
//                System.out.println("Position: "+position);
//                System.out.println("First name: "+firstName);
//                System.out.println("Last name: "+lastName);
//                System.out.println("Date: "+date);
//                System.out.println("Nationality: "+nationality);
//                System.out.println();


                ++i;
               driver.navigate().back();
            }
            if(driver.findElements(By.xpath("//*[@id=\"site\"]/div[3]/div[1]/div/div[2]/div/table/tbody/tr/td[7]/a")).isEmpty()) break;

            String arrow = "//*[@id=\"site\"]/div[3]/div[1]/div/div[2]/div/table/tbody/tr/td[7]/a";
            ((JavascriptExecutor)driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");

            action.moveToElement(driver.findElement(By.xpath(arrow)));
            action.click().build().perform();
        }
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");

    }
}
