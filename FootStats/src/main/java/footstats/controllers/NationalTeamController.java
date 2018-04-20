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
@RequestMapping(path = "/nationalTeam")
public class NationalTeamController {

    @Autowired
    NationalTeamService nationalTeamService;

    @Autowired
    CountryService countryService;

    @Autowired
    CompetitionService competitionService;

    @GetMapping(path = "/all")
    public Iterable<NationalTeam> getAllNationalTeam(){
        return nationalTeamService.findAll();
    }

    @PostMapping(path = "/add")
    public String addNewNationalTeam(@RequestParam String name,
                                     @RequestParam String competitionName){

        NationalTeam nt = new NationalTeam();
        nt.setName(name);

        Country country = countryService.findByName(name);
        nt.setCountry(country);

        Competition comp = competitionService.findByName(competitionName);
        nt.setCompetition(comp);

        nationalTeamService.save(nt);
        return "Saved National Team";
    }

    @PostMapping(path = "/delete")
    public String deleteNationalTeam(@RequestParam String name){
        NationalTeam nt = nationalTeamService.findByName(name);

        if (nt.getId() == null){
            return "Wrong National Team ID";
        }
        nationalTeamService.deleteById(nt.getId());
        return "Deleted National Team";
    }

    @PostMapping(path = "/update")
    public String updateNationalTeam(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) String competitionName){

        NationalTeam nt = nationalTeamService.findByName(name);
        Competition c = nt.getCompetition();
        if(c.getName() != competitionName){
            Competition competition = competitionService.findByName(competitionName);
            nt.setCompetition(competition);
        }
            nationalTeamService.save(nt);

        return "Saved National Team";
    }
}
