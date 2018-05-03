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
import java.util.List;

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
        importEnglishClubs(driver, url);

        url = "https://en.wikipedia.org/wiki/List_of_football_clubs_in_Italy";
        importItalyClubs(driver, url);

        driver.close();
        driver.quit();
    }

    public void importItalyClubs(WebDriver driver, String url){
        driver.get(url);
        Document doc;

        try {
            doc = Jsoup.connect(url).get();

            Element table;
            table = doc.select("table").get(0); //select the first table.

            int m = 0;
            for (Element row : table.select("tr")) {
                Elements tds = row.select("td");
                Elements head = row.select("th");
                if(m != 0){
                    clubs.add(tds.get(0).text());
                    city.add(tds.get(1).text());
                    stadiums.add(tds.get(2).text());
                    competition.add("Serie A");
                }
                ++m;
            }
            m = 0;

            table = doc.select("table").get(1);
            for (Element row : table.select("tr")) {
                Elements tds = row.select("td");
                Elements head = row.select("th");
                if(m != 0){
                    clubs.add(tds.get(0).text());
                    city.add(tds.get(1).text());
                    stadiums.add(tds.get(2).text());
                    competition.add("Serie B");
                }
                ++m;
            }


            for(int i = 0; i < clubs.size(); i++){
                System.out.println("Tim: "+clubs.get(i)+" -> Grad: "+city.get(i)+" -> Stadion: "+stadiums.get(i)+" -> Takmicenje: "+competition.get(i));
            }

            Country country = countryService.findByName("Italy");
            for(int i = 0; i < clubs.size(); i++){
                Club club = new Club();
                club.setName(clubs.get(i));
                City c = cityService.findByName(city.get(i));
                Competition comp = competitionService.findByName(competition.get(i));
                List<Stadium> s = stadiumService.findStadiumsByName(stadiums.get(i));

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

                if(s == null || s.size() == 0){
                    Stadium stadium = new Stadium();
                    stadium.setName(stadiums.get(i));

                    stadiumService.save(stadium);
                    club.setStadium(stadium);
                    System.out.println("Stadion: "+stadium.getName());
                }else{
                    club.setStadium(s.get(0));
                }

                club.setCompetition(comp);

                clubService.save(club);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        clubs.clear();
        city.clear();
        stadiums.clear();
        competition.clear();

    }

    public  void importEnglishClubs(WebDriver driver, String url){
        driver.get(url);
        Document doc;
        try {
            doc = Jsoup.connect(url).get();

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

        for(int i = 0; i < clubs.size(); i++){
            System.out.println(clubs.get(i)+" -> Grad: "+city.get(i)+" -> Stadion: "+stadiums.get(i)+" -> Takmicenje: "+competition.get(i));
        }

        Country country = countryService.findByName("England");
        for(int i = 1; i < clubs.size(); i++){
            Club club = new Club();
            club.setName(clubs.get(i));
            if(club.getName().contains("Ladies")) continue;

            City c = cityService.findByName(city.get(i));
            Competition comp = competitionService.findByName(competition.get(i));
            List<Stadium> s = stadiumService.findStadiumsByName(stadiums.get(i));

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

            if(s == null || s.size() == 0){
                Stadium stadium = new Stadium();
                stadium.setName(stadiums.get(i));

                stadiumService.save(stadium);
                club.setStadium(stadium);
                System.out.println("Stadion: "+stadium.getName());
            }else{
                club.setStadium(s.get(0));
            }

            club.setCompetition(comp);

            clubService.save(club);
        }

        clubs.clear();
        city.clear();
        stadiums.clear();
        competition.clear();
    }
}
