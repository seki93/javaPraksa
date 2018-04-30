package footstats.dataImport;

import footstats.model.*;
import footstats.service.*;
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
    @Autowired
    CountryService countryService;


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
                for (Element row : table.select("tr")) {
                    Elements tds = row.select("td");
                    if(m != 0){
                        if(tds.size() > 4){
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

        for(int i = 0; i < clubs.size(); i++){
            System.out.println(clubs.get(i)+" -> Grad: "+city.get(i)+" -> Stadion: "+stadiums.get(i)+" -> Takmicenje: "+competition.get(i));
        }

        Country country = countryService.findByName("England");
        for(int i = 1; i < clubs.size(); i++){
            Club club = new Club();
            club.setName(clubs.get(i));
            if(club.getName().contains("Ladies")) continue;
            //System.out.println("Dodajem u bazu: "+clubs.get(i)+" Grad: "+city.get(i)+" Takmicenje: "+competition.get(i)+" Stadion: "+stadiums.get(i));

            City c = cityService.findByName(city.get(i));
            Competition comp = competitionService.findByName(competition.get(i));
            Iterable<Stadium> s = stadiumService.findStadiumsByName(stadiums.get(i));

            if(c == null){
                City newCity = new City();
                newCity.setName(city.get(i));
                System.out.println("Ime grada je "+newCity.getName());
                newCity.setCountry(country);
                cityService.save(newCity);
                club.setCity(newCity);
            }else{
                club.setCity(c);
            }

            club.setCompetition(comp);
            club.setStadium(s.iterator().next());

            clubService.save(club);
        }
    }
}
