package footstats.controllers;

import footstats.model.MatchStats;
import footstats.service.MatchStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/matchstats")
public class MatchStatsController {

    @Autowired
    MatchStatsService matchStatsService;

    @GetMapping(path = "/all")
    public Iterable<MatchStats> getAllMatchStats(){
        return matchStatsService.findAll();
    }

//    @PostMapping(path = "/add")
//    public String addNewMatchStats(){
//
//        MatchStats ms = new MatchStats();
//
//
//        matchStatsService.save(ms);
//        return "Saved MatchStats";
//    }

    @PostMapping(path = "/delete")
    public String deleteMatchStats(@RequestParam Integer id){
        if(id == null)
            return "Wrong MatchStats ID";

        matchStatsService.deleteById(id);
        return "MatchStats deleted";
    }


}
