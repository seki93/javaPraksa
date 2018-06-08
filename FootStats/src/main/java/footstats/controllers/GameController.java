package footstats.controllers;

import footstats.model.Club;
import footstats.model.Game;
import footstats.model.MatchStats;
import footstats.model.Referee;
import footstats.service.ClubService;
import footstats.service.GameService;
import footstats.service.MatchStatsService;
import footstats.service.RefereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/game")
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    ClubService clubService;

    @Autowired
    RefereeService refereeService;

    @Autowired
    MatchStatsService matchStatsService;

    @GetMapping(path = "/all")
    public Iterable<Game> getAllGame(){
        return gameService.findAll();
    }

    @PostMapping(path = "/add")
    public String addNewGame(@RequestParam Integer awayclub_id,
                              @RequestParam Integer homeclub_id,
                              @RequestParam Integer referee_id,
                             @RequestParam Integer matchstats_id){

            Game g = new Game();

        Club c1 = clubService.findById(awayclub_id);
        g.setHomeClub(c1);

        Club c2 = clubService.findById(homeclub_id);
        g.setAwayClub(c2);

        Referee referee = refereeService.findById(referee_id);
        g.setReferee(referee);

        MatchStats matchstats = matchStatsService.findById(matchstats_id);
        g.setMatchStats(matchstats);

        gameService.save(g);
        return "Game Saved";
    }
    @PostMapping(path = "/delete")
    public String deleteGame(@RequestParam Integer id){
        if (id == null)
            return "Wrong Game ID";

        gameService.deleteById(id);
        return "Game Deleted";
    }

    @PostMapping(path = "/find/all")
    public Iterable<Game> getFindAllMatch(@RequestParam String clubName){

        return gameService.findAllMatch(clubName);
    }

    @PostMapping(path = "/find/home/allWin")
    public Iterable<Game> getAllWinAtHome(@RequestParam String clubName){
        Pageable pageable = null;

        return gameService.findWinHome(clubName, pageable);
    }

    @PostMapping(path = "/find/home/win")
    public  Iterable<Game> getFindWinAtHome(@RequestParam String clubName, @RequestParam Integer number){

        return gameService.findNNumbersOfWinAtHome(clubName, number);
    }

    @PostMapping(path = "/find/home/allDrawn")
    public Iterable<Game> getAllDrawnAtHome(@RequestParam String clubName){
        Pageable pageable = null;

        return gameService.findDrawnAtHome(clubName, pageable);
    }

    @PostMapping(path = "/find/home/drawn")
    public Iterable<Game> getFindDrawnAtHome(@RequestParam String clubName, @RequestParam Integer number){

        return gameService.findNNumbersOfDrawnAtHome(clubName, number);
    }

    @PostMapping(path = "/find/home/allLost")
    public Iterable<Game> getAllLostAtHome(@RequestParam String clubName){
        Pageable pageable = null;

        return gameService.findLostAtHome(clubName, pageable);
    }

    @PostMapping(path = "/find/home/lost")
    public Iterable<Game> getLostAtHome(@RequestParam String clubName, @RequestParam Integer number){

        return  gameService.findNLostAtHome(clubName, number);
    }

    @GetMapping(path = "/find/home/allWin/halfTime")
    public List<Game> findWinHomeOnHalfTime(@RequestParam String clubName){
        Pageable pageable = null;

        return gameService.findWinHomeOnHalfTime(clubName, pageable);
    }
    @GetMapping(path = "/find/home/win/halfTime")
    public List<Game> findNWinAtHomeOnHalfTime(@RequestParam String clubName, @RequestParam Integer number){

        return gameService.findNWinAtHomeOnHalfTime(clubName, number);
    }

    @GetMapping(path = "/find/home/allLost/halfTime")
    public List<Game> findLostHomeOnHalfTime(@RequestParam String clubName){
        Pageable pageable = null;

        return gameService.findLostHomeOnHalfTime(clubName, pageable);
    }

    @GetMapping(path = "/find/home/lost/halfTime")
    public List<Game> findNLostAtHomeOnHalfTime(@RequestParam String clubName, @RequestParam Integer number){

        return gameService.findNLostAtHomeOnHalfTime(clubName, number);
    }

    @GetMapping(path = "/find/home/allDraw/halfTime")
    public List<Game> findDrawHomeOnHalfTime(@RequestParam String clubName){
        Pageable pageable = null;

        return gameService.findDrawHomeOnHalfTime(clubName, pageable);
    }

    @GetMapping(path = "/find/home/draw/halfTime")
    public List<Game> findNDrawAtHomeOnHalfTime(@RequestParam String clubName, @RequestParam Integer number){

        return gameService.findNDrawAtHomeOnHalfTime(clubName, number);
    }

    @GetMapping(path = "/find/home/average/yellowCards")
    public List<Game> findAverageOfYellowCardsAtHome(@RequestParam String clubName){

        return gameService.findAverageOfYellowCardsAtHome(clubName);
    }

    @GetMapping(path = "/find/home/average/redCards")
    public List<Game> findAverageOfRedCardsAtHome(@RequestParam String clubName){

        return gameService.findAverageOfRedCardsAtHome(clubName);
    }

    @GetMapping(path = "/find/home/average/cornerKicks")
    public List<Game> findAverageOfCornerKicksAtHome(@RequestParam String clubName){

        return gameService.findAverageOfCornerKicksAtHome(clubName);
    }

    @GetMapping(path = "/find/home/average/totalPasses")
    public List<Game> findAverageOfTotalPassesAtHome(@RequestParam String clubName){

        return gameService.findAverageOfTotalPassesAtHome(clubName);
    }

    //AWAY

    @PostMapping(path = "/find/away/allWin")
    public Iterable<Game> findAllWinAway(@RequestParam String clubName){
        Pageable pageable = null;
        System.out.println(gameService.findWinAway(clubName, pageable).size());
        return gameService.findWinAway(clubName, pageable);
    }

    @PostMapping(path = "/find/away/win")
    public Iterable<Game> findNNumbersOfWinAway(@RequestParam String clubName, @RequestParam Integer number){

        return gameService.findNNumbersOfWinsAway(clubName, number);
    }

    @PostMapping(path = "/find/away/allLost")
    public Iterable<Game> findAllLost(@RequestParam String clubName){
        Pageable pageable = null;

        return gameService.findAllLostAway(clubName, pageable);
    }

    @PostMapping(path = "/find/away/lost")
    public Iterable<Game> findNLostAway(@RequestParam String clubName, @RequestParam Integer number){

        return gameService.findNLostAway(clubName, number);
    }

    @PostMapping(path = "/find/away/allDrawn")
    public Iterable<Game> findAllDrawnAway(@RequestParam String clubName){
        Pageable pageable = null;

        return gameService.findDrawnAway(clubName,pageable);
    }

    @PostMapping(path = "/find/away/drawn")
    public Iterable<Game> findNDrawnAway(@RequestParam String clubName, @RequestParam Integer number){

        return gameService.findNNumbersOfDrawnAway(clubName, number);
    }

    @GetMapping(path = "/find/away/allWin/halfTime")
    public List<Game> findWinAwayOnHalfTime(@RequestParam String clubName){
        Pageable pageable = null;

        return gameService.findWinAwayOnHalfTime(clubName, pageable);
    }

    @GetMapping(path = "/find/away/win/halfTime")
    public List<Game> findNWinAwayOnHalfTime(@RequestParam String clubName, @RequestParam Integer number){

        return gameService.findNWinAwayOnHalfTime(clubName, number);
    }

    @GetMapping(path = "/find/away/allLost/halfTime")
    public List<Game> findLostAwayOnHalfTime(@RequestParam String clubName){
        Pageable pageable = null;

        return gameService.findLostAwayOnHalfTime(clubName, pageable);
    }

    @GetMapping(path = "/find/away/lost/halfTime")
    public List<Game> findNLostAwayOnHalfTime(@RequestParam String clubName, @RequestParam Integer number){

        return gameService.findNLostAwayOnHalfTime(clubName, number);
    }

    @GetMapping(path = "/find/away/allDraw/halfTime")
    public List<Game> findDrawAwayOnHalfTime(@RequestParam String clubName){
        Pageable pageable = null;

        return gameService.findDrawAwayOnHalfTime(clubName, pageable);
    }

    @GetMapping(path = "/find/away/draw/halfTime")
    public List<Game> findNDrawAwayOnHalfTime(@RequestParam String clubName, @RequestParam Integer number){

        return gameService.findNDrawAwayOnHalfTime(clubName, number);
    }

    @GetMapping(path = "/find/away/average/yellowCards")
    public List<Game> findAverageOfYellowCardsAway(@RequestParam String clubName){

        return gameService.findAverageOfYellowCardsAway(clubName);
    }

    @GetMapping(path = "/find/away/average/redCards")
    public List<Game> findAverageOfRedCardsAway(@RequestParam String clubName){

        return gameService.findAverageOfRedCardsAway(clubName);
    }

    @PostMapping(path = "/find/H2H/all")
    public List<Game> findH2Hall(@RequestParam String homeClub, String awayClub){
        Pageable pageable = null;

        return gameService.findH2HallMatches(homeClub, awayClub, pageable);
    }

    @PostMapping(path = "/find/H2H")
    public List<Game> findH2HNumbers(@RequestParam String homeClub,@RequestParam String awayClub, @RequestParam Integer number){

        return gameService.findH2HnNumbersOfMatch(homeClub, awayClub, number);
    }

    @GetMapping(path = "/find/away/average/cornerKicks")
    public List<Game> findAverageOfCornerKicksAway(@RequestParam String clubName){

        return gameService.findAverageOfCornerKicksAway(clubName);
    }

    @PostMapping(path = "/find/goals")
    public List<Game> findNgolas(@RequestParam Integer goals){

        return gameService.findNgoals(goals);
    }

    @GetMapping(path = "/find/away/average/totalPasses")
    public List<Game> findAverageOfTotalPassesAway(@RequestParam String clubName){

        return gameService.findAverageOfTotalPassesAway(clubName);
    }
}
