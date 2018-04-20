package footstats.controllers;

import footstats.model.Competition;
import footstats.model.Country;
import footstats.model.Rank;
import footstats.service.CompetitionService;
import footstats.service.CountryService;
import footstats.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/competition")
public class CompetitionController {

    @Autowired
    CompetitionService competitionService;

    @Autowired
    RankService rankService;

    @Autowired
    CountryService countryService;

    @GetMapping(path = "/all")
    public Iterable<Competition> getAllCompetition(){
        return competitionService.findAll();
    }

    @PostMapping(path = "/add")
    public String addNewCompetition(@RequestParam String name,
                                    @RequestParam String rankName,
                                    @RequestParam String countryName){

        Competition c = new Competition();
        c.setName(name);

        Rank r = rankService.findByName(rankName);
        c.setRank(r);

        Country country = countryService.findByName(countryName);
        c.setCountry(country);

        competitionService.save(c);
        return " Saved Competition ";
        }

    @PostMapping(path = "/delete")
    public String deleteCompetition(@RequestParam String name){
        Competition c = competitionService.findByName(name);

        if (c.getId() == null)
            return " Wrong Competition ID";

        competitionService.deleteById(c.getId());
        return " Deleted Competition";
    }

    @PostMapping(path = "/update")
    public String updateCompetition(@RequestParam String name,
                                    @RequestParam String rankName,
                                    @RequestParam String countryName){

        Competition c = competitionService.findByName(name);
        Rank r = rankService.findByName(rankName);
        Country country = countryService.findByName(countryName);
        if(c.getId() != null){

            if(c.getName() != name){
                c.setName(name);
            }

            if(c.getRank() != r){
                c.setRank(r);
            }

            if(c.getCountry() != country){
                c.setCountry(country);
            }

            competitionService.save(c);
            return " Updated Competition ";

        }
        return "Wrong Competition name";

    }

}
