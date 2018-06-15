package footstats.dataImport;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import footstats.model.Club;
import footstats.model.Game;
import footstats.model.MatchStats;
import footstats.service.ClubService;
import footstats.service.GameService;
import footstats.service.MatchStatsService;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.NoSuchElementException;


@Service
public class GameReImport {
    @Autowired
    private ClubService clubService;

    @Autowired
    private GameService gameService;

    @Autowired
    private MatchStatsService matchStatsService;

    public void popUpWindowTest(WebDriver driver, WebElement element, Actions action) throws InterruptedException, ParseException {
        Set s = driver.getWindowHandles();
        String mainWindowHandle=driver.getWindowHandle();

        action.moveToElement(element);
        action.click().build().perform();

        Iterator ite = s.iterator();

        while(ite.hasNext()){

            String popupHandle= ite.next().toString();
            if(!popupHandle.contains(mainWindowHandle)){
                driver.switchTo().window(popupHandle);
                Game game = new Game();
                MatchStats matchStats = new MatchStats();
                try {
                if (!driver.findElements(By.xpath("//*[@id=\"a-match-statistics\"]")).isEmpty()){

                    Thread.sleep(1500);

                    //Proverava da li postoji home klub / ako ne, upisuje u bazu
                    String homeClub = driver.findElement(By.xpath("//*[@id=\"flashscore_column\"]/table/tbody/tr[1]/td[1]/span/a")).getText();
                    if (clubService.findByName(homeClub) == null) {
                        Club homeClubUpis = new Club();
                        homeClubUpis.setName(homeClub);
                        clubService.save(homeClubUpis);
                    }
                    game.setHomeClub(clubService.findByName(homeClub));

                    //Proverava da li postoji away klub / ako ne, upisuje u bazu
                    String awayClub = driver.findElement(By.xpath("//*[@id=\"flashscore_column\"]/table/tbody/tr[1]/td[3]/span/a")).getText();
                    if (clubService.findByName(awayClub) == null) {
                        Club awayClubInsert = new Club();
                        awayClubInsert.setName(awayClub);
                        clubService.save(awayClubInsert);
                    }
                    game.setAwayClub(clubService.findByName(awayClub));

                    // kupi half time golove
                    Thread.sleep(2500);
                    String halfTimeResult = driver.findElement(By.className("score")).getText();
                    String homeTeamHalfTimeGoals = halfTimeResult.substring(0,1);
                    int homeTeamHalfTimeGoalsInsert = Integer.parseInt(homeTeamHalfTimeGoals);

                    String awayTeamHalfTimeGoals = halfTimeResult.substring(4,5);
                    int awayTeamHalfTimeGoalsInsert = Integer.parseInt(awayTeamHalfTimeGoals);

                    //cuva half time golove
                    matchStats.setHalf_time_goals_homeclub(homeTeamHalfTimeGoalsInsert);
                    matchStats.setHalf_time_goals_awayclub(awayTeamHalfTimeGoalsInsert);

                    //kupi krajnji rezultat
                    String endGameResult = driver.findElement(By.className("current-result")).getText();
                    String homeTeamEndGameGoals = endGameResult.substring(0,1);
                    int homeTeamEndGameInsert = Integer.parseInt(homeTeamEndGameGoals);

                    String awayTeamEndGameGoals = endGameResult.substring(2,3);
                    int awayTeamEndGameInsert = Integer.parseInt(awayTeamEndGameGoals);
                    //cuva krajnji rezultat
                    matchStats.setGoals_homeclub(homeTeamEndGameInsert);
                    matchStats.setGoals_awayclub(awayTeamEndGameInsert);

                    String dateXpath= driver.findElement(By.className("mstat-date")).getText();
                    String dateYear = dateXpath.substring(6,10);
                    String dateDays = dateXpath.substring(0,2);
                    String dateMonth = dateXpath.substring(3,5);
                    String date = dateYear + "-" + dateMonth + "-" + dateDays;
                    System.out.println(date);
                    SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
                    Date dateInsert = parser.parse(date);
                    game.setDate(dateInsert);

                    action.moveToElement(driver.findElement(By.xpath("//*[@id=\"a-match-statistics\"]")));
                    action.click().build().perform();

                    Thread.sleep(500);
                    int i = 1;
                    if (!driver.findElements(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody")).isEmpty()){

                        if (!driver.findElements(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]")).isEmpty()) {
                            if (driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]")).getText().contains("Ball Possession")) {
                                int ballPossessionHomeTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[1]/div[1]")).getText().substring(0, 2));
                                int ballPossessionAwayTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[3]/div[2]")).getText().substring(0, 2));

                                matchStats.setBall_possession_hometeam(ballPossessionHomeTeamInsert);
                                matchStats.setBall_possession_awayteam(ballPossessionAwayTeamInsert);
                                i++;
                            }
                        }
                        if (!driver.findElements(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]")).isEmpty()){
                         if (driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]")).getText().contains("Goal Attempts")){
                            int goalAttemptsHomeTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]/td[1]/div[1]")).getText());
                            int goalAttemptsAwayTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]/td[3]/div[2]")).getText());

                            matchStats.setGoal_attempts_hometeam(goalAttemptsHomeTeamInsert);
                            matchStats.setGoal_attempts_awayteam(goalAttemptsAwayTeamInsert);
                            i++;
                         }
                        }
                        if (!driver.findElements(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]")).isEmpty()) {
                        if (driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]")).getText().contains("Shots on Goal")) {
                            int shotsOnGoalHomeTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[1]/div[1]")).getText());
                            int shotsOnGoalAwayTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[3]/div[2]")).getText());

                            matchStats.setShots_on_goal_hometeam(shotsOnGoalHomeTeamInsert);
                            matchStats.setShots_on_goal_awayteam(shotsOnGoalAwayTeamInsert);
                            i++;
                        }
                        }
                        if (!driver.findElements(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]")).isEmpty()) {
                            if (driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]")).getText().contains("Shots off Goal")) {
                                int shotsOffGoalHomeTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[1]/div[1]")).getText());
                                int shotsOffGoalAwayTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[3]/div[2]")).getText());

                                matchStats.setShots_off_goal_hometeam(shotsOffGoalHomeTeamInsert);
                                matchStats.setShots_off_goal_awayteam(shotsOffGoalAwayTeamInsert);
                                i++;
                            }
                        }
                        if (!driver.findElements(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]")).isEmpty()) {
                            if (driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]")).getText().contains("Blocked Shots")) {
                                int blockedShotsHomeTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[1]/div[1]")).getText());
                                int blockedShotsAwayTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[1]/div[1]")).getText());

                                matchStats.setBlocked_shots_hometeam(blockedShotsHomeTeamInsert);
                                matchStats.setBlocked_shots_awayteam(blockedShotsAwayTeamInsert);
                                i++;
                            }
                        }
                        if (!driver.findElements(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]")).isEmpty()) {
                            if (driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]")).getText().contains("Free Kicks")) {
                                int freeKicksHomeTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[1]/div[1]")).getText());
                                int freeKicksAwayTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[3]/div[2]")).getText());

                                matchStats.setFree_kicks_hometeam(freeKicksHomeTeamInsert);
                                matchStats.setFree_kicks_awayteam(freeKicksAwayTeamInsert);
                                i++;
                            }
                        }
                        if (!driver.findElements(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]")).isEmpty()) {
                            if (driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]")).getText().contains("Corner Kicks")) {
                                int cornerKicksHomeTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[7]/td[1]/div[1]")).getText());
                                int cornerKicksAwayTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[7]/td[3]/div[2]")).getText());

                                matchStats.setCorner_kicks_hometeam(cornerKicksHomeTeamInsert);
                                matchStats.setCorner_kicks_awayteam(cornerKicksAwayTeamInsert);
                                i++;
                            }
                        }
                        if (!driver.findElements(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]")).isEmpty()) {
                            if (driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]")).getText().contains("Offsides")) {
                                int offsidesHomeTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[1]/div[1]")).getText());
                                int offsidesAwayTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[1]/div[1]")).getText());

                                matchStats.setOffsides_hometeam(offsidesHomeTeamInsert);
                                matchStats.setOffsides_awayteam(offsidesAwayTeamInsert);
                                i++;
                            }
                        }
                        if (!driver.findElements(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]")).isEmpty()) {
                            if (driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]")).getText().contains("Goalkeeper Saves")) {
                                int goalkeeperSavesHomeTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[1]/div[1]")).getText());
                                int goalkeeperSavesAwayTeam = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[3]/div[2]")).getText());

                                matchStats.setGoalkeeper_saves_hometeam(goalkeeperSavesHomeTeamInsert);
                                matchStats.setGoalkeeper_saves_awayteam(goalkeeperSavesAwayTeam);
                                i++;
                            }
                        }
                        if (!driver.findElements(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]")).isEmpty()) {
                            if (driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]")).getText().contains("Fouls")) {
                                int foulsHomeTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[1]/div[1]")).getText());
                                int foulsAwayTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[3]/div[2]")).getText());

                                matchStats.setFouls_hometeam(foulsHomeTeamInsert);
                                matchStats.setFouls_awayteam(foulsAwayTeamInsert);
                                i++;
                            }
                        }
                        if (!driver.findElements(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]")).isEmpty()) {
                            if (driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]")).getText().contains("Red Cards")) {
                                int redCardsHomeTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[1]/div[1]")).getText());
                                int redCardsAwayTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[3]/div[2]")).getText());

                                matchStats.setRed_cards_hometeam(redCardsHomeTeamInsert);
                                matchStats.setRed_cards_awayteam(redCardsAwayTeamInsert);
                                i++;
                            }
                        }
                        if (!driver.findElements(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]")).isEmpty()) {
                            if (driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]")).getText().contains("Yellow Cards")) {
                                int yellowCardsHomeTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[1]/div[1]")).getText());
                                int yellowCardsAwayTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[3]/div[2]")).getText());

                                matchStats.setYellow_cards_hometeam(yellowCardsHomeTeamInsert);
                                matchStats.setYellow_cards_awayteam(yellowCardsAwayTeamInsert);
                                i++;
                            }
                        }
                        if (!driver.findElements(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]")).isEmpty()) {
                            if (driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]")).getText().contains("Total Passes")) {
                                int totalPassesHomeTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[1]/div[1]")).getText());
                                int totalPassesAwayTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[3]/div[2]")).getText());

                                matchStats.setTotal_passes_hometeam(totalPassesHomeTeamInsert);
                                matchStats.setTotal_passes_awayteam(totalPassesAwayTeamInsert);
                                i++;
                            }
                        }
                        if (!driver.findElements(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr["+i+"]")).isEmpty()) {
                            if (driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]")).getText().contains("Tackles")) {
                                int tacklesHomeTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[1]/div[1]")).getText());
                                int tacklesAwayTeamInsert = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"tab-statistics-0-statistic\"]/table/tbody/tr[" + i + "]/td[3]/div[2]")).getText());

                                matchStats.setTackles_hometeam(tacklesHomeTeamInsert);
                                matchStats.setTackles_awayteam(tacklesAwayTeamInsert);
                                i++;
                            }
                        }
                        matchStatsService.save(matchStats);
                        game.setMatchStats(matchStats);
                        gameService.save(game);
                    }
                } else {
                    //Proverava da li postoji home klub / ako ne, upisuje u bazu
                    Thread.sleep(3000);

                        String homeClub = driver.findElement(By.xpath("//*[@id=\"flashscore_column\"]/table/tbody/tr[1]/td[1]/span/a")).getText();
                        if (clubService.findByName(homeClub) == null) {
                            Club homeClubUpis = new Club();
                            homeClubUpis.setName(homeClub);
                            clubService.save(homeClubUpis);
                        }
                        game.setHomeClub(clubService.findByName(homeClub));
                        //Proverava da li postoji away klub / ako ne, upisuje u bazu
                        String awayClub = driver.findElement(By.xpath("//*[@id=\"flashscore_column\"]/table/tbody/tr[1]/td[3]/span/a")).getText();
                        if (clubService.findByName(awayClub) == null) {
                            Club awayClubInsert = new Club();
                            awayClubInsert.setName(awayClub);
                            clubService.save(awayClubInsert);
                        }
                        game.setAwayClub(clubService.findByName(awayClub));
                        // kupi half time golove
                        String halfTimeResult = driver.findElement(By.className("score")).getText();
                        System.out.println(halfTimeResult + " ovo je half time result koji pravi sranja");
                        String homeTeamHalfTimeGoals = halfTimeResult.substring(0, 1);
                        int homeTeamHalfTimeGoalsInsert = Integer.parseInt(homeTeamHalfTimeGoals);

                        String awayTeamHalfTimeGoals = halfTimeResult.substring(4, 5);
                        int awayTeamHalfTimeGoalsInsert = Integer.parseInt(awayTeamHalfTimeGoals);
                        //cuva half time golove
                        matchStats.setHalf_time_goals_homeclub(homeTeamHalfTimeGoalsInsert);
                        matchStats.setHalf_time_goals_awayclub(awayTeamHalfTimeGoalsInsert);
                        //kupi krajnji rezultat
                        String endGameResult = driver.findElement(By.className("current-result")).getText();
                        System.out.println(endGameResult + " ovo je engame result");
                        String homeTeamEndGameGoals = endGameResult.substring(0, 1);
                        int homeTeamEndGameInsert = Integer.parseInt(homeTeamEndGameGoals);

                        String awayTeamEndGameGoals = endGameResult.substring(2, 3);
                        int awayTeamEndGameInsert = Integer.parseInt(awayTeamEndGameGoals);
                        //cuva krajnji rezultat
                        matchStats.setGoals_homeclub(homeTeamEndGameInsert);
                        matchStats.setGoals_awayclub(awayTeamEndGameInsert);

                        String dateXpath= driver.findElement(By.xpath("//*[@id=\"utime\"]")).getText();
                        String dateYear = dateXpath.substring(6,10);
                        String dateDays = dateXpath.substring(0,2);
                        String dateMonth = dateXpath.substring(3,5);
                        String date = dateYear + "-" + dateMonth + "-" + dateDays;
                        System.out.println(date);
                        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
                        Date dateInsert = parser.parse(date);
                        game.setDate(dateInsert);

                        game.setMatchStats(matchStats);
                        matchStatsService.save(matchStats);
                        gameService.save(game);

                        }


                    } catch (StaleElementReferenceException e){
                        System.out.println("Bacio exception " + e);
                    }
                    catch (IndexOutOfBoundsException e){
                        System.out.println("Bacio exception " + e);
                    }
                    catch (NoSuchElementException e){
                        System.out.println("Bacio exception " + e);
                    } catch (NumberFormatException e){
                        System.out.println("Bacio exception " + e);
                    } catch (TimeoutException e){
                        System.out.println("Bacio exception " + e);
                    }
                driver.close();
            }
        }
        driver.switchTo().window(mainWindowHandle);
    }

    public void reImportGames() throws InterruptedException, ParseException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String url = "https://www.soccer24.com";
        driver.navigate().to(url);

        Actions action = new Actions(driver);
        int i = 36;
        while (i < 250) {
            //prolazi kroz zemlje
            String country = "//*[@id=\"lmenu_"+ i +"\"]/a";

            if (driver.findElements(By.xpath(country)).isEmpty()) {
                i++;
                continue;
            }

            int j = 1;
            while (true) { //true
                //ulazi u zemlje
                if ( i == 47 ){
                    i++;
                }
                action.moveToElement(driver.findElement(By.xpath(country)));
                action.click().build().perform();
                Thread.sleep(1000);
                //trazi lige
                String league = "//*[@id=\"lmenu_" + i + "\"]/ul/li[" + j + "]/a";
                if (driver.findElements(By.xpath(league)).isEmpty()) {
                    break;
                }
                //ulazi u lige
                action.moveToElement(driver.findElement(By.xpath(league)));
                action.click().build().perform();

                //ulazi u rezultate lige
                String results = "//*[@id=\"fscon\"]/div[2]/ul/li[2]/span/a";
                action.moveToElement(driver.findElement(By.xpath(results)));
                action.click().build().perform();
                Thread.sleep(1500);
                //otvara show more
                for (int expand = 0; expand < 5; expand++) {

                    ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0)");
                    Thread.sleep(1000);
                    if (!driver.findElements(By.xpath("//*[@id=\"tournament-page-results-more\"]/tbody/tr/td/a")).isEmpty()) {
                        WebElement exp = driver.findElement(By.xpath("//*[@id=\"tournament-page-results-more\"]/tbody/tr/td/a"));
                        action.moveToElement(exp);
                        action.click(exp);
                        action.build().perform();
                    }
                }
                //prolazi kroz meceve
                int z = 2;
                int p = 1;

                if (!driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + z + "]/td")).isEmpty()) {
                    while (!driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + z + "]/td")).isEmpty()) {
                        try {
                            if (driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + z + "]/td")).size()<0){
                                j++;
                                continue;
                            }
                            if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + z + "]/td")).getText().contains("Round")) {
                                z++;
                                continue;
                            }
                            if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + z + "]/td")).getText().contains("Final")) {
                                z++;
                                continue;
                            }
                            if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + z + "]/td")).getText().contains("final")) {
                                z++;
                                continue;
                            }
                            if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + z + "]/td")).getText().contains("place")) {
                                z++;
                                continue;
                            }

                            List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + z + "]/td"));
                            for (int r = 0; r < list.size(); r = r + 2){
                                WebElement ele = list.get(r);
                                popUpWindowTest(driver, ele, action);
                            }
                            z++;
                        } catch (StaleElementReferenceException e){
                            System.out.println("Bacio exception " + e);
                        }
                          catch (IndexOutOfBoundsException e){
                            System.out.println("Bacio exception " + e);
                        }
                        catch (NoSuchElementException e){
                            System.out.println("Bacio exception " + e);
                        }
                    }
                    j++;
                } else if (!driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr[1]/td")).isEmpty()) {

                    while (!driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr["+z+"]/td")).isEmpty()) {
                        while (!driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr[" + z + "]/td")).isEmpty()) {
                            try {
                                if (driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr[" + z + "]/td")).size()<0) {
                                    j++;
                                    continue;
                                }
                                if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr[" + z + "]/td")).getText().contains("Round")) {
                                    z++;
                                    continue;
                                }

                                if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr[" + z + "]/td")).getText().contains("Final")) {
                                    z++;
                                    continue;
                                }
                                if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr[" + z + "]/td")).getText().contains("final")) {
                                    z++;
                                    continue;
                                }
                                if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr[" + z + "]/td")).getText().contains("place")) {
                                    z++;
                                    continue;
                                }

                                List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table[" + p + "]/tbody/tr["+z+"]/td"));
                                for (int r = 0; r < list.size(); r = r + 2){
                                    WebElement ele = list.get(r);
                                    popUpWindowTest(driver, ele, action);
                                }
                                z++;
                            } catch (StaleElementReferenceException e){
                                System.out.println("Bacio exception " + e);
                            }
//                            catch (IndexOutOfBoundsException e){
//                                System.out.println("Bacio exception " + e);
//                            }
                            catch (NoSuchElementException e){
                                System.out.println("Bacio exception " + e);
                            }
                        }
                        p++;
                    }
                    j++;
                } else if (driver.findElement(By.xpath("//*[@id=\"fscon\"]/div[1]/div[2]")).getText().contains("Super Cup")) {
                    int t = 1;
                    while (!driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + t + "]/td")).isEmpty()) {
                        try {
                            if (driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + t + "]/td")).size()<0) {
                                t++;
                                continue;
                            }
                            if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + t + "]/td")).getText().contains("Round")) {
                                t++;
                                continue;
                            }
                            if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + t + "]/td")).getText().contains("Final")) {
                                t++;
                                continue;
                            }
                            if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + t + "]/td")).getText().contains("final")) {
                                t++;
                                continue;
                            }
                            if (driver.findElement(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + t + "]/td")).getText().contains("place")) {
                                t++;
                                continue;
                            }

                            List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"fs-results\"]/table/tbody/tr[" + t + "]/td"));
                            for (int r = 0; r < list.size(); r = r + 2){
                                WebElement ele = list.get(r);
                                popUpWindowTest(driver, ele, action);
                            }
                            t++;
                        } catch (StaleElementReferenceException e){
                            System.out.println("Bacio exception " + e);
                        }
//                        catch (IndexOutOfBoundsException e){
//                            System.out.println("Bacio exception " + e);
//                        }
                        catch (NoSuchElementException e){
                            System.out.println("Bacio exception " + e);
                        }
                    }
                    i++;
                }
            }
            i++;
        }
        driver.close();
        driver.quit();
    }
}