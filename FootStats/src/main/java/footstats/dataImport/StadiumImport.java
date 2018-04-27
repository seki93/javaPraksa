package footstats.dataImport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import footstats.model.Stadium;
import footstats.service.StadiumService;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.openqa.selenium.interactions.Actions;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

        WebElement rows1;
        ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());

        for(int i = 3; i <= 64; i++){
            rows1 = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/div["+i+"]"));
            System.out.println(rows1.getText());

            if(!driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/div["+i+"]/a")).getText().contains("incomplete")){
                tabs1.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/div["+i+"]/a")).getAttribute("href"));
            }
        }

       for(int i = 1; i < tabs1.size(); i++){

            Document doc;
            try {
                doc = Jsoup.connect(tabs1.get(i)).get();
                // get title of the page
                String title = doc.title();
                System.out.println("Title: " + title);

                if(title.equals("List of football stadiums in Sweden - Wikipedia") || title.equals("List of football stadiums in Uruguay - Wikipedia")||
                        title.equals("Stadiums in Bangladesh - Wikipedia") || title.equals("List of stadiums in Wales by capacity - Wikipedia")) continue;
                Element table;

                if (title.equals("List of soccer stadiums in the United States - Wikipedia") ||
                        title.equals("List of football stadiums in Croatia - Wikipedia") ||
                        title.equals("List of football stadiums in Finland - Wikipedia") ||
                        title.equals("List of football stadiums in France - Wikipedia") ||
                        title.equals("List of football stadiums in Germany - Wikipedia") ||
                        title.equals("List of football stadiums in Italy - Wikipedia") ||
                        title.equals("List of football stadiums in Mexico - Wikipedia") ||
                        title.equals("List of football stadiums in Poland - Wikipedia") ||
                        title.equals("List of football stadiums in Portugal - Wikipedia") ||
                        title.equals("List of association football stadiums in Northern Ireland - Wikipedia") ||
                        title.equals("List of football stadiums in Scotland - Wikipedia")) {

                    table = doc.select("table").get(1); //select the first table.
                } else {
                    table = doc.select("table").get(0); //select the first table.
                }

                    int indeks = 0;
                    Elements defPointsAllowedRows =table.select("tr");

                    for (int j = 0; j < defPointsAllowedRows.size(); j++) {
                        Element row = defPointsAllowedRows.get(j);
                        Elements cols = row.select("td");
                        Elements head = row.select("th");


                        if(j == 0 ){
                            if(head.get(0).text().equals("Stadium")){
                                indeks = 0;
                            }else if(head.get(1).text().equals("Stadium")){
                                indeks = 1;
                            }else if(head.get(2).text().contains("Stadium")){
                                indeks = 2;
                            }
                        }

                        if(title.equals("List of football stadiums in England - Wikipedia") && cols.size() == 8 && j >0){
                            stadiums.add(cols.get(indeks).text());
                            if(cols.get(indeks).text().equals("Fortress Stadium")) break;
                        }else if(!title.equals("List of football stadiums in England - Wikipedia")){
                            if(j > 0) stadiums.add(cols.get(indeks).text());
                        }
                    }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        driver.close();
        driver.quit();


         try {
             for(String s: stadiums) {
                 Stadium stadium = new Stadium();
                 stadium.setName(s);
                 stadiumService.save(stadium);
             }
         } catch (Exception e) {
             log.debug("Got an exception!");
             log.debug(e.getMessage());
         }

    }
}
