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
import org.springframework.web.bind.annotation.*;

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
                              @RequestParam Integer matchstats_id,
                              @RequestParam Integer referee_id){

        Game g = new Game();

        Club c1 = clubService.findById(awayclub_id);
        g.setHomeClub(c1);

        Club c2 = clubService.findById(homeclub_id);
        g.setAwayClub(c2);

        MatchStats ms = matchStatsService.findById(matchstats_id);
        g.setMatchStats(ms);

        Referee referee = refereeService.findById(referee_id);
        g.setReferee(referee);

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

    @PostMapping(path = "/update")
    public String updateGame(@RequestParam Integer id,
                              @RequestParam(required = false) Integer id_homeclub,
                              @RequestParam(required = false) Integer id_awayclub,
                              @RequestParam(required = false) String refereeFirstName,
                             @RequestParam(required = false) String refereeLastName,
                              @RequestParam(required = false) Integer id_matchstats){
        Game g = gameService.findById(id);
        if(g.getId() == id){
            if(id_homeclub != null){
                Club c1 = new Club();
                c1 = clubService.findById(id_homeclub);
                g.setHomeClub(c1);
            }
            if(id_awayclub != null){
                Club c2 = new Club();
                c2 = clubService.findById(id_awayclub);
                g.setAwayClub(c2);
            }
            if(refereeFirstName != null && refereeLastName != null){
//                Referee ref = refereeService.findById(refereeService.findIdByName(refereeFirstName, refereeLastName));
//                g.setReferee(ref);
            }
            if(id_matchstats != null){
                MatchStats ms = new MatchStats();
                ms = matchStatsService.findById(id_matchstats);
                g.setMatchStats(ms);
            }
            gameService.save(g);
            return "Saved Game";

        }
        return "Wrong Game ID";
    }
}
