package footstats.dataImport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CompetitionImport {

    final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SekiSelenijum.class);

    private ArrayList<String> englandCompetitions = new ArrayList<>();
    private ArrayList<String> germanyCompetitions = new ArrayList<>();
    private ArrayList<String> italyCompetitions = new ArrayList<>();
    private ArrayList<String> spainCompetitions = new ArrayList<>();
    private ArrayList<String> franceCompetitions = new ArrayList<>();
    private ArrayList<String> serbiaCompetitions = new ArrayList<>();
    private ArrayList<String> internationalCompetitions = new ArrayList<>();

    private ArrayList<Integer> ranks = new ArrayList<>();

    private int id, idEngland, idGermany, idItaly, idSpain, idFrance, idSerbia, idInternational;

    private int prviRank, drugiRank, treciRank, cetvrtiRank, petiRank;


    @Test
    public void simpleChromeDrivertest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        log.debug("Opening browser");
        driver.manage().window().maximize();
        String url = "https://en.wikipedia.org/wiki/List_of_association_football_competitions";
        log.debug("navigating to the " + url);
        driver.get(url);

        Actions actions = new Actions(driver);

        Thread.sleep(5000);

        for(int i = 2; i < 7;i++) {

            englandCompetitions.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[39]/tbody/tr["+ i +"]/td[1]/a")).getText());
        }

        for(int i = 2;i < 7;i++){

            germanyCompetitions.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[42]/tbody/tr["+ i +"]/td[2]/a")).getText());
        }

        for(int i = 1;i < 3;i++ ){

            italyCompetitions.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/ul[146]/li/ul/li[1]/ul/li["+ i +"]/a")).getText());

        }

        for(int i = 2;i < 3;i++ ){

            italyCompetitions.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/ul[146]/li/ul/li[2]/a")).getText());
            italyCompetitions.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/ul[146]/li/ul/li[3]/ul/li/a")).getText());

        }

        for(int i = 2;i < 7;i++ ){

            spainCompetitions.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[50]/tbody/tr["+ i +"]/td[2]/a")).getText());

        }

        for(int i = 2;i < 7;i++ ){

            franceCompetitions.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[41]/tbody/tr["+ i +"]/td[1]/a")).getText());
        }

        for(int i = 2;i < 5;i++ ){

            serbiaCompetitions.add(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/table[49]/tbody/tr["+ i +"]/td[2]/a")).getText());

        }


        System.out.println(englandCompetitions);
        System.out.println(germanyCompetitions);
        System.out.println(italyCompetitions);
        System.out.println(spainCompetitions);
        System.out.println(franceCompetitions);
        System.out.println(serbiaCompetitions);


        try {

            String myUrl = "jdbc:mysql://localhost:3306/footstats";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            String query = "select * from footstats.rank where name IN ('1', '2', '3', '4', '5')";

            PreparedStatement preparedStmt2 = conn.prepareStatement(query);

            ResultSet rs = preparedStmt2.executeQuery();

            while(rs.next()) {
                id = rs.getInt("id");
                String a = rs.getString("Name");
                System.out.println("Name: " + a + ": " + id);
                if (a.equals("1")) prviRank = id;
                else if (a.equals("2")) drugiRank = id;
                else if (a.equals("3")) treciRank = id;
                else if (a.equals("4")) cetvrtiRank = id;
                else petiRank = id;

                ranks.add(id);
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }

        try {

            String myUrl = "jdbc:mysql://localhost:3306/footstats";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            String query = "select * from footstats.country where name IN ('England', 'Germany', 'Italy', 'Spain', 'France', 'Serbia', 'International')";

            PreparedStatement preparedStmt = conn.prepareStatement(query);

            ResultSet rs = preparedStmt.executeQuery();

            while(rs.next()) {
                id = rs.getInt("id");
                String a = rs.getString("Name");
                System.out.println("Name: " + a + ": " + id);
                if (a.equals("England")) idEngland = id;
                else if (a.equals("France")) idFrance = id;
                else if (a.equals("Germany")) idGermany = id;
                else if (a.equals("Spain")) idSpain = id;
                else if (a.equals("Italy")) idItaly = id;
                else if (a.equals("Serbia")) idSerbia = id;
                else idInternational = id;

            }


            conn.close();

        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }

        Thread.sleep(5000);
        log.debug("Closing browser");
        driver.close();
        driver.quit();

        try {

            String myUrl = "jdbc:mysql://localhost:3306/footstats";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            String query1 = " Insert into competition (name, country_id, rank_id) values(?, ?, ?)";

            PreparedStatement preparedStmt1 = conn.prepareStatement(query1);

            for(int i = 0;i < englandCompetitions.size();i++){

                preparedStmt1.setString(1, "" + englandCompetitions.get(i));
                preparedStmt1.setInt(2, idEngland);
                preparedStmt1.setInt(3, ranks.get(i));

                preparedStmt1.execute();
            }

            for(int i = 0;i < germanyCompetitions.size();i++){

                preparedStmt1.setString(1, "" + germanyCompetitions.get(i));
                preparedStmt1.setInt(2, idGermany);
                preparedStmt1.setInt(3, ranks.get(i));

                preparedStmt1.execute();
            }

            for(int i = 0;i < italyCompetitions.size();i++){

                preparedStmt1.setString(1, "" + italyCompetitions.get(i));
                preparedStmt1.setInt(2, idItaly);
                preparedStmt1.setInt(3, ranks.get(i));

                preparedStmt1.execute();
            }

            for(int i = 0;i < spainCompetitions.size();i++){

                preparedStmt1.setString(1, "" + spainCompetitions.get(i));
                preparedStmt1.setInt(2, idSpain);
                preparedStmt1.setInt(3, ranks.get(i));

                preparedStmt1.execute();
            }

            for(int i = 0;i < franceCompetitions.size();i++){

                preparedStmt1.setString(1, "" + franceCompetitions.get(i));
                preparedStmt1.setInt(2, idFrance);
                preparedStmt1.setInt(3, ranks.get(i));

                preparedStmt1.execute();
            }

            for(int i = 0;i < serbiaCompetitions.size();i++){

                preparedStmt1.setString(1, "" + serbiaCompetitions.get(i));
                preparedStmt1.setInt(2, idSerbia);
                preparedStmt1.setInt(3, ranks.get(i));

                preparedStmt1.execute();
            }

            conn.close();

        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
    }
}
