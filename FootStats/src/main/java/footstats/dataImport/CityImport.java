package footstats.dataImport;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CityImport {


    final static Logger log = Logger.getLogger(StadiumImport.class);

    private ArrayList<String> englandCities = new ArrayList<String>();
    private ArrayList<String> italyCities = new ArrayList<String>();
    private ArrayList<String> spainCities = new ArrayList<String>();
    private ArrayList<String> germanyCities = new ArrayList<String>();
    private ArrayList<String> franceCities = new ArrayList<String>();
    private Integer id;
    private Integer idEngland;
    private Integer idFrance;
    private Integer idSpain;
    private Integer idGermany;
    private Integer idItaly;
    private static String citiesString = "";

    @Test
    public void simpleChromeDrivertest() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        log.debug("Opening browser");
        driver.manage().window().maximize();

        try {

            String myUrl = "jdbc:mysql://localhost:3306/footstats";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            String queryIdCountry = " SELECT * FROM footstats.country where name IN ('England', 'Spain', 'Italy', 'Germany', 'France')";

            PreparedStatement preparedStmt = conn.prepareStatement(queryIdCountry);

            ResultSet rs = preparedStmt.executeQuery();

            while(rs.next()){
                id = rs.getInt("id");
                String a = rs.getString("Name");
                System.out.println("Name: "+a+": "+id);
                if(a.equals("England")) idEngland = id;
                else if(a.equals("France")) idFrance = id;
                else if(a.equals("Germany")) idGermany = id;
                else if(a.equals("Spain")) idSpain = id;
                else idItaly = id;
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }

        //ENGLAND CITIES
        String url = "https://simple.wikipedia.org/wiki/List_of_cities_and_towns_in_England";
        driver.get(url);

        for(int i = 3; i <= 26; i++){
            String count = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/p["+i+"]")).getText();
            citiesString+= count+", ";
        }

        String[] parts = citiesString.split(",");
        for(int i = 0; i < parts.length; i++){
            englandCities.add(parts[i]);
        }

        //ITALY CITIES
        String url2 = "https://en.wikipedia.org/wiki/List_of_cities_in_Italy";
        driver.get(url2);
        citiesString = "";
        for(int i = 1; i <= 144; i++){
            italyCities.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[1]/tbody/tr["+i+"]/td[2]")).getText());
        }

        //SPAIN CITIES
        String url3 = "https://population.mongabay.com/population/spain/";
        driver.get(url3);

        for(int i = 1; i <=  569; i++){
            spainCities.add(driver.findElement(By.xpath("//*[@id=\"myTable\"]/tbody/tr["+i+"]/td[1]/a")).getText());
        }

        //GERMANY CITIES
        String url4 = "https://en.wikipedia.org/wiki/List_of_cities_and_towns_in_Germany";
        driver.get(url4);

        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div/table[25]/tbody/td"));
        rows = driver.findElements(By.xpath(" //*[@id=\"mw-content-text\"]/div/table[25]/tbody/tr[2]/td[1]/ul/li"));

        for(int i = 1; i <= 25; i++){
            for(int j = 1; j <=3 ; j++){
                rows = driver.findElements(By.xpath(" //*[@id=\"mw-content-text\"]/div/table["+i+"]/tbody/tr[2]/td["+j+"]/ul/li"));
                for(int k = 1; k<= rows.size(); k++){
                    germanyCities.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table["+i+"]/tbody/tr[2]/td["+j+"]/ul/li["+k+"]/a")).getText());
                }
            }
        }

        //FRANCE CITIES
        String url5 = "https://simple.wikipedia.org/wiki/List_of_cities_in_France";
        driver.get(url5);

        for(int i = 1; i <= 434; i++){
            franceCities.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table/tbody/tr["+i+"]/td[1]")).getText());
        }


        driver.close();
        driver.quit();

        System.out.println(germanyCities.size());
        System.out.println(germanyCities);

        try {

            String myUrl = "jdbc:mysql://localhost:3306/footstats";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            String query = " Insert into city (name, country_id) values(?,?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            conn.setAutoCommit(false);


            for(String s: englandCities){
                preparedStmt.setString(1, s);
                preparedStmt.setInt(2, idEngland);
                preparedStmt.addBatch();
            }

            for(String s: italyCities){
                preparedStmt.setString(1, s);
                preparedStmt.setInt(2, idItaly);
                preparedStmt.addBatch();
            }

            for(String s: spainCities){
                preparedStmt.setString(1, s);
                preparedStmt.setInt(2, idSpain);
                preparedStmt.addBatch();
            }

            for(String s: germanyCities){
                preparedStmt.setString(1, s);
                preparedStmt.setInt(2, idGermany);
                preparedStmt.addBatch();
            }

            for(String s: franceCities){
                preparedStmt.setString(1, s);
                preparedStmt.setInt(2, idFrance);
                preparedStmt.addBatch();
            }
            preparedStmt.executeBatch();
            conn.commit();

            conn.close();
        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }

    }


}
