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

    @PostMapping(path = "/add")
    public String addNewMatchStats(@RequestParam Integer assistance,
                                   @RequestParam Integer cards_hometeam,
                                   @RequestParam Integer cards_awayteam,
                                   @RequestParam String endResult,
                                   @RequestParam Integer fouls_hometeam,
                                   @RequestParam Integer fouls_awayteam,
                                   @RequestParam String halfTimeResult,
                                   @RequestParam Float passPercent_hometeam,
                                   @RequestParam Float passPercent_awayteam){

        MatchStats ms = new MatchStats();
        ms.setAssistance(assistance);
        ms.setCards_hometeam(cards_hometeam);
        ms.setCards_awayteam(cards_awayteam);
        ms.setEndResult(endResult);
        ms.setFouls_hometeam(fouls_hometeam);
        ms.setFouls_awayteam(fouls_awayteam);
        ms.setHalfTimeResult(halfTimeResult);
        ms.setPassPercent_hometeam(passPercent_hometeam);
        ms.setPassPercent_awayteam(passPercent_awayteam);

        matchStatsService.save(ms);
        return "Saved MatchStats";
    }

    @PostMapping(path = "/delete")
    public String deleteMatchStats(@RequestParam Integer id){
        if(id == null)
            return "Wrong MatchStats ID";

        matchStatsService.deleteById(id);
        return "MatchStats deleted";
    }
    @PostMapping(path = "/update")
    public String updateMatchStats(@RequestParam Integer id,
                                   @RequestParam(required = false) String endResult,
                                   @RequestParam(required = false) String halfTimeResult,
                                   @RequestParam(required = false) Integer assistance,
                                   @RequestParam(required = false) Integer fouls_hometeam,
                                   @RequestParam(required = false) Integer fouls_awayteam,
                                   @RequestParam(required = false) Integer cards_hometeam,
                                   @RequestParam(required = false) Integer cards_awayteam,
                                   @RequestParam(required = false) Float passPercent_hometeam,
                                   @RequestParam(required = false) Float passPercent_awayteam){

        MatchStats ms = matchStatsService.findById(id);
        if (ms.getId() == id){
            if (endResult != null){
                ms.setEndResult(endResult);
            }
            if (halfTimeResult != null){
                ms.setHalfTimeResult(halfTimeResult);
            }
            if (assistance != null){
                ms.setAssistance(assistance);
            }
            if(fouls_hometeam != null){
                ms.setFouls_hometeam(fouls_hometeam);
            }
            if(fouls_awayteam != null){
                ms.setFouls_awayteam(fouls_awayteam);
            }
            if(cards_hometeam != null){
                ms.setCards_hometeam(cards_hometeam);
            }
            if(cards_awayteam!= null){
                ms.setCards_awayteam(cards_awayteam);
            }
            if(passPercent_hometeam != null){
                ms.setPassPercent_hometeam(passPercent_hometeam);
            }
            if(passPercent_awayteam != null){
                ms.setPassPercent_awayteam(passPercent_awayteam);
            }

            matchStatsService.save(ms);
            return "Updated MatchStats";
        }

        return "Wrong MatchStats ID";
    }

}
