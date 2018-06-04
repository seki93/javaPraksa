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

}
