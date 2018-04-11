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
                                    @RequestParam Integer id_rank,
                                    @RequestParam Integer id_country){

        Competition c = new Competition();
        c.setName(name);
        Rank r = rankService.findById(id_rank);
        c.setRank(r);

        Country country = countryService.findById(id_country);
        c.setCountry(country);

        competitionService.save(c);
        return " Saved Competition ";
        }

    @PostMapping(path = "/delete")
    public String deleteCompetition(@RequestParam Integer id){
        if (id == null)
            return " Wrong Competition ID";

        competitionService.deleteById(id);
        return " Deleted Competition";
    }

    @PostMapping(path = "/update")
    public String updateCompetition(@RequestParam Integer id,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) Integer id_rank,
                                    @RequestParam(required = false) Integer id_country){

        Competition c = competitionService.findById(id);
        if(c.getId() == id){
            if(name != null){
                c.setName(name);
            }
            if(id_rank != null){
                Rank rank = new Rank();
                rank = rankService.findById(id_rank);
                c.setRank(rank);
            }
            if (id_country != null){
                Country country = new Country();
                country = countryService.findById(id_country);
                c.setCountry(country);
            }
            competitionService.save(c);
            return " Updated Competition ";

        }
        return "Wrong Competition ID";

    }

}
