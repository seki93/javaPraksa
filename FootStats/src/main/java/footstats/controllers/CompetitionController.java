package footstats.controllers;

import footstats.model.Competition;
import footstats.model.Country;
import footstats.model.NationalTeam;
import footstats.service.CompetitionService;
import footstats.service.CountryService;
import footstats.service.NationalTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/competition")
public class CompetitionController {

    @Autowired
    CompetitionService competitionService;

    @Autowired
    CountryService countryService;

    @Autowired
    NationalTeamService nationalTeamService;

    @GetMapping(path = "/all")
    public Iterable<Competition> getAllCompetition(){
        return competitionService.findAll();
    }

    @PostMapping(path = "/add")
    public String addNewCompetition(@RequestParam String name,
                                    @RequestParam String countryName,
                                    @RequestParam String nationalTeamName,
                                    @RequestParam Integer rank){

        Competition c = new Competition();
        c.setName(name);

        Country country = countryService.findByName(countryName);
        c.setCountry(country);

        NationalTeam nationalTeam = nationalTeamService.findByName(nationalTeamName);
        c.addNationalTeam(nationalTeam);

        c.setRank(rank);

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
                                    @RequestParam String countryName,
                                    @RequestParam Integer rank){

        Competition c = competitionService.findByName(name);
        Country country = countryService.findByName(countryName);
        if(c.getId() != null){

            if(c.getName() != name){
                c.setName(name);
            }

            if(c.getCountry() != country){
                c.setCountry(country);
            }

            if (c.getRank() != rank){
                c.setRank(rank);
            }

            competitionService.save(c);
            return " Updated Competition ";

        }
        return "Wrong Competition name";

    }

}
