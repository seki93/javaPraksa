package footstats.dataImport;

import footstats.model.City;
import footstats.model.Club;
import footstats.model.Competition;
import footstats.model.Stadium;
import footstats.service.CityService;
import footstats.service.ClubService;
import footstats.service.CompetitionService;
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
    @Autowired
    CompetitionService competitionService;


   private ArrayList<String> clubs  = new ArrayList<String>();
   private ArrayList<String> city = new ArrayList<String>();
   private ArrayList<String> stadiums = new ArrayList<String>();
   private ArrayList<String> competition = new ArrayList<String>();

    public void importClubs(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://en.wikipedia.org/wiki/List_of_football_stadiums_in_England";
        driver.get(url);
            Document doc;
            try {
                doc = Jsoup.connect(url).get();
                String title = doc.title();

                Element table;

                table = doc.select("table").get(0); //select the first table.

                int m = 0;
                System.out.println("Nasao sam link za Eneglesku");
                System.out.println("Ulazim u petlju i pisem sve o Engleskim klubovima");
                for (Element row : table.select("tr")) {
                    Elements tds = row.select("td");
                    if(m != 0){
                        if(tds.size() <= 2){
//                          System.out.println("Velicina td-a:");
//                          System.out.println(tds.size());
                            System.out.println(tds.get(0).text());
                            System.out.println(tds.get(1).text());
                        }else if(tds.size() <= 3){
//                          System.out.println("Velicina td-a:");
//                          System.out.println(tds.size());
                            System.out.println(tds.get(0).text());
                            System.out.println(tds.get(1).text());
                            System.out.println(tds.get(2).text());
                        }else if(tds.size() <= 4){
//                          System.out.println("Velicina td-a:");
//                          System.out.println(tds.size());
                            System.out.println(tds.get(0).text());
                            System.out.println(tds.get(1).text());
                            System.out.println(tds.get(2).text());
                            System.out.println(tds.get(3).text());
                        }else{
//                          System.out.println("Velicina td-a:");
//                          System.out.println(tds.size());
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        driver.close();
        driver.quit();
        System.out.println();
        System.out.println();
        System.out.println("ISPISUJEM SVE O KLUBOVIMA KOJE SAM NASAO");
        for(int i = 0; i < clubs.size(); i++){
            System.out.println(clubs.get(i)+" -> Grad: "+city.get(i)+" -> Stadion: "+stadiums.get(i)+" -> Takmicenje: "+competition.get(i));
        }
        System.out.println("Broj klubova: "+clubs.size());
        System.out.println("Broj gradova: "+city.size());
        System.out.println("Broj stadiona: "+stadiums.size());

        System.out.println();
        System.out.println();
        System.out.println("DODAJEM IH U BAZU");
        for(int i = 1; i < clubs.size(); i++){
            Club club = new Club();
            club.setName(clubs.get(i));

            System.out.println("Dodajem u bazu: "+clubs.get(i)+" Grad: "+city.get(i)+" Takmicenje: "+competition.get(i)+" Stadion: "+stadiums.get(i));

            City c = cityService.findByName(city.get(i));
            Competition comp = competitionService.findByName(competition.get(i));
            Stadium s = stadiumService.findByName(stadiums.get(i));
            System.out.println("Trazim stadion: "+s.getName());
            System.out.println("Trazim grad: "+c.getName());
            System.out.println("Trazim takmicenje: "+comp.getName());

            if(c.getName().length() > 0) club.setCity(c);
            else System.out.println("Ne postoji grad");

            if(comp.getName().length() > 0) club.setCompetition(comp);
            else System.out.println("Ne postoji takimcenje");

            if(s.getName().length() > 0) club.setStadium(s);
            else System.out.println("Ne postoji stadion");

            clubService.save(club);
        }
    }
}
