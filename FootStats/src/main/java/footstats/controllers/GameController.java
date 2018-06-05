package footstats.controllers;

import footstats.model.Club;
import footstats.model.Game;
import footstats.model.MatchStats;
import footstats.model.Referee;
import footstats.service.ClubService;
import footstats.service.GameService;
import footstats.service.MatchStatsService;
import footstats.service.RefereeService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.net.Inet4Address;
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

    @GetMapping(path = "/homeWin")
    public List<Game> findWinHomeOnHalfTime(@RequestParam String clubName){

        return gameService.findWinHomeOnHalfTime(clubName);
    }

    @GetMapping(path = "/homeLost")
    public List<Game> findLostHomeOnHalfTime(@RequestParam String clubName){

        return gameService.findLostHomeOnHalfTime(clubName);
    }

    @GetMapping(path = "/homeDraw")
    public List<Game> findDrawHomeOnHalfTime(@RequestParam String clubName){

        return gameService.findDrawHomeOnHalfTime(clubName);
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

    @GetMapping(path = "/awayWin")
    public List<Game> findWinAwayOnHalfTime(@RequestParam String clubName){

        return gameService.findWinAwayOnHalfTime(clubName);
    }

    @GetMapping(path = "/awayLost")
    public List<Game> findLostAwayOnHalfTime(@RequestParam String clubName){

        return gameService.findLostAwayOnHalfTime(clubName);
    }

    @GetMapping(path = "/awayDraw")
    public List<Game> findDrawAwayOnHalfTime(@RequestParam String clubName){

        return gameService.findDrawAwayOnHalfTime(clubName);
    }
}
