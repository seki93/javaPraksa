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
                                   @RequestParam Integer cards,
                                   @RequestParam String endResult,
                                   @RequestParam Integer fouls,
                                   @RequestParam String halfTimeResult,
                                   @RequestParam Float passPercent){

        MatchStats ms = new MatchStats();
        ms.setAssistance(assistance);
        ms.setCards(cards);
        ms.setEndResult(endResult);
        ms.setFouls(fouls);
        ms.setHalfTimeResult(halfTimeResult);
        ms.setPassPercent(passPercent);

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
                                   @RequestParam(required = false) Integer fouls,
                                   @RequestParam(required = false) Integer cards,
                                   @RequestParam(required = false) Float passPercent){

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
            if(fouls != null){
                ms.setFouls(fouls);
            }
            if(cards != null){
                ms.setCards(cards);
            }
            if(passPercent != null){
                ms.setPassPercent(passPercent);
            }

            matchStatsService.save(ms);
            return "Updated MatchStats";
        }

        return "Wrong MatchStats ID";
    }

}
