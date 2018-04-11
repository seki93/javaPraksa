package footstats.controllers;

import com.sun.jna.IntegerType;
import footstats.model.Club;
import footstats.model.Match;
import footstats.model.MatchStats;
import footstats.model.Referee;
import footstats.service.ClubService;
import footstats.service.MatchService;
import footstats.service.MatchStatsService;
import footstats.service.RefereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/match")
public class MatchController {

    @Autowired
    MatchService matchService;

    @Autowired
    ClubService clubService;

    @Autowired
    RefereeService refereeService;

    @Autowired
    MatchStatsService matchStatsService;

    @GetMapping(path = "/all")
    public Iterable<Match> getAllMatch(){
        return matchService.findAll();
    }

    @PostMapping(path = "/add")
    public String addNewMatch(@RequestParam Integer id_homeclub,
                              @RequestParam Integer id_awayclub,
                              @RequestParam Integer id_referee,
                              @RequestParam Integer id_matchstats){
        Match m = new Match();

        Club c1 = clubService.findById(id_homeclub);
        m.setHomeClub(c1);

        Club c2 = clubService.findById(id_awayclub);
        m.setAwayClub(c2);

        Referee referee = refereeService.findById(id_referee);
        m.setReferee(referee);

        MatchStats ms = matchStatsService.findById(id_matchstats);
        m.setMatchStats(ms);

        matchService.save(m);
        return "Match Saved";
    }

    @PostMapping(path = "/delete")
    public String deleteMatch(@RequestParam Integer id){
        if (id == null)
            return "Wrong Match ID";

        matchService.deleteById(id);
        return "Match Deleted";
    }

    @PostMapping(path = "/update")
    public String updateMatch(@RequestParam Integer id,
                              @RequestParam(required = false) Integer id_homeclub,
                              @RequestParam(required = false) Integer id_awayclub,
                              @RequestParam(required = false) Integer id_referee,
                              @RequestParam(required = false) Integer id_matchstats){
    Match m = matchService.findById(id);
    if(m.getId() == id){
        if(id_homeclub != null){
            Club c1 = new Club();
            c1 = clubService.findById(id_homeclub);
            m.setHomeClub(c1);
            }
        if(id_awayclub != null){
            Club c2 = new Club();
            c2 = clubService.findById(id_awayclub);
            m.setAwayClub(c2);
        }
        if(id_referee != null){
            Referee ref = new Referee();
            ref = refereeService.findById(id_referee);
            m.setReferee(ref);
        }
        if(id_matchstats != null){
            MatchStats ms = new MatchStats();
            ms = matchStatsService.findById(id_matchstats);
            m.setMatchStats(ms);
        }
        matchService.save(m);
        return "Saved Match";

    }
        return "Wrong Match ID";
    }
}
