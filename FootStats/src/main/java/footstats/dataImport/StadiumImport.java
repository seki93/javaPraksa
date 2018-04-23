package footstats.dataImport;

import java.util.ArrayList;
import java.util.List;


import footstats.model.Stadium;
import footstats.service.StadiumService;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.openqa.selenium.interactions.Actions;

@Service
public class StadiumImport {

    final static Logger log = Logger.getLogger(StadiumImport.class);

    private ArrayList<String> stadiums = new ArrayList<String>();
    private ArrayList<String> links = new ArrayList<String>();

    @Autowired
    StadiumService stadiumService;

    public void importStadiums() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        log.debug("Opening browser");
        driver.manage().window().maximize();

        String url = "https://en.wikipedia.org/wiki/List_of_association_football_stadiums_by_country";
        driver.get(url);

        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[2]/tbody/tr"));
        List<WebElement> rows2;

//        for(int i = 2; i <= 83; i++){
//            rows = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table["+i+"]/tbody/tr"));
//            if(i == 54) i++;
//            for(int j = 2; j < rows.size(); j++){
//                if(i == 21 || i == 40 || i == 39 || i == 47 || i == 48 || i == 69 || i == 70){                                 //*[@id="mw-content-text"]/div/table[39]/tbody/tr[3]/td[2]
//                    stadiums.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table["+i+"]/tbody/tr["+j+"]/td[2]")).getText());
//
//                }else {
//                    stadiums.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table["+i+"]/tbody/tr["+j+"]/td[1]")).getText());
//                }
//            }
//        }
        WebElement rows1;
        for(int i = 3; i <= 64; i++){
            rows1 = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/div["+i+"]"));
            System.out.println(rows1.getText());

            Actions action = new Actions(driver);
            String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
            //System.out.println(action.moveToElement(rows1).moveToElement(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/div["+i+"]/a"))));
            //System.out.println(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/div["+i+"]/a")).getAttribute("href"));
            if(!driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/div["+i+"]/a")).getText().contains("incomplete")){
                links.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/div["+i+"]/a")).getAttribute("href"));
            }

//            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//            driver.switchTo().window(tabs.get(1)); //switches to new tab
//            driver.get("https://www.facebook.com");
//
//            driver.switchTo().window(tabs.get(0)); // switch back to main screen
//            driver.get("https://www.news.google.com");

            //action.moveToElement(we).moveToElement(webdriver.findElement(By.xpath("expression"))).click().build().perform();
        }
        int a = 0;

        List<WebElement> tableRows = null;

       for(String l: links){
           System.out.println(a+" "+l);
           a++;
       }
        a = 0 ;
        for(int i = 0; i < links.size(); i++){
            driver.navigate().to(links.get(i));
            rows2 = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table/thead/tr/th"));
            rows = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table/tbody/tr"));

            //*[@id="mw-content-text"]/div/table/tbody/tr[1]/th[3]
            //*[@id="mw-content-text"]/div/table/thead/tr/th[3]
            //*[@id="mw-content-text"]/div/table/tbody/tr[1]/th[3]
            //*[@id="mw-content-text"]/div/table/thead/tr/th[2]
            if(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table/thead/tr/th[3]")).getText().equals("Stadium") ||
                    driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table/tbody/tr[1]/th[3]")).getText().equals("Stadium")){
                System.out.println(a+" Stadio je na 3 mestu");
                a++;
            }else if(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table/thead/tr/th[2]")).getText().equals("Stadium")){
                System.out.println(a+" Stadion je na 2 mestu");
                a++;
            }else{
                System.out.println(a+" Nesto sto mi ne treba se nalazi ovde");
                a++;
            }
//            System.out.println(tableRows);
//            System.out.println(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table/thead/tr/th")));
//            System.out.println("Link: "+links.get(i));
//            System.out.println(rows2.size());
//            System.out.println(rows.size());
//            a+=rows.size();

//            for(int j = 1; j < rows.size(); j++){
//                //*[@id="mw-content-text"]/div/table[1]/tbody/tr[1]/td[2]
//                //*[@id="mw-content-text"]/div/table/tbody/tr[2]/td[3]
//                //*[@id="mw-content-text"]/div/table/tbody/tr[1]/td[3]
//                stadiums.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table/tbody/tr["+j+"]/td[2]")).getText());
//            }
        }



        driver.close();
        driver.quit();

        System.out.println(links);
        System.out.println(links.size());

//         try {
//             for(String s: stadiums) {
//                 Stadium stadium = new Stadium();
//                 stadium.setName(s);
//                 stadiumService.save(stadium);
//             }
//         } catch (Exception e) {
//             log.debug("Got an exception!");
//             log.debug(e.getMessage());
//         }

    }
}
