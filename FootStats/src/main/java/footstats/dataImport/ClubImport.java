package footstats.dataImport;

import footstats.model.City;
import footstats.model.Club;
import footstats.model.Stadium;
import footstats.service.CityService;
import footstats.service.ClubService;
import footstats.service.StadiumService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class ClubImport {

    @Autowired
    ClubService clubService;

    @Autowired
    StadiumService stadiumService;
    @Autowired
    CityService cityService;


    ArrayList<String> clubs  = new ArrayList<String>();
    ArrayList<String> city = new ArrayList<String>();
    ArrayList<String> stadiums = new ArrayList<String>();
    ArrayList<String> competition = new ArrayList<String>();

    public void importClubs(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
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

                Element table;

                if(title.equals("List of soccer stadiums in the United States - Wikipedia") ||
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
                }else{
                    table = doc.select("table").get(0); //select the first table.
                }


                int m = 0;
                if(title.equals("List of football stadiums in England - Wikipedia")){
                    for (Element row : table.select("tr")) {
                        Elements tds = row.select("td");
                        if(m != 0){
                            if(tds.size() <= 2){
//                                System.out.println("Velicina td-a:");
//                                System.out.println(tds.size());
                                System.out.println(tds.get(0).text());
                                System.out.println(tds.get(1).text());
                            }else if(tds.size() <= 3){
//                                System.out.println("Velicina td-a:");
//                                System.out.println(tds.size());
                                System.out.println(tds.get(0).text());
                                System.out.println(tds.get(1).text());
                                System.out.println(tds.get(2).text());
                            }else if(tds.size() <= 4){
//                                System.out.println("Velicina td-a:");
//                                System.out.println(tds.size());
                                System.out.println(tds.get(0).text());
                                System.out.println(tds.get(1).text());
                                System.out.println(tds.get(2).text());
                                System.out.println(tds.get(3).text());
                            }else{
//                                System.out.println("Velicina td-a:");
//                                System.out.println(tds.size());
                                System.out.println(tds.get(4).text());
                                clubs.add(tds.get(4).text());
                                stadiums.add(tds.get(1).text());
                                city.add(tds.get(2).text());
                                competition.add(tds.get(5).text());


                                if(tds.get(4).text().equals("Bromley")) break;
                            }
                        }
                        ++m;
                    }
                    clubs.add("Tottenham Hotspur");
                    stadiums.add("Wembley Stadium");
                    city.add("London");
                    competition.add("Premier League");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.close();
        driver.quit();

        for(int i = 0; i < clubs.size(); i++){
            System.out.println(clubs.get(i)+" -> Grad: "+city.get(i)+" -> Stadion: "+stadiums.get(i)+" -> Takmicenje: "+competition.get(i));
        }
        System.out.println("Broj klubova: "+clubs.size());
        System.out.println("Broj gradova: "+city.size());
        System.out.println("Broj stadiona: "+stadiums.size());

//        for(int i = 0; i < clubs.size(); i++){
//            Club club = new Club();
//            club.setName(clubs.get(i));
//
//            Stadium s = stadiumService.findByName(stadiums.get(i));
//            City c = cityService.findByName(city.get(i));
//
//            if(s != null) club.setStadium(s);
//            else System.out.println("Ne postoji stadion");
//
//            if(c != null) club.setCity(c);
//            else System.out.println("Ne postoji grad");
//
//            clubService.save(club);
//        }
    }
}
