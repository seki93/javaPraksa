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
@RequestMapping(path = "/nationalteam")
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
                                     @RequestParam Integer id_country,
                                     @RequestParam Integer id_competition){

        NationalTeam nt = new NationalTeam();
        nt.setName(name);

        Country country = countryService.findById(id_country);
        nt.setCountry(country);

        Competition comp = competitionService.findById(id_competition);
        nt.setCompetition(comp);

        nationalTeamService.save(nt);
        return "Saved National Team";
    }

    @PostMapping(path = "/delete")
    public String deleteNationalTeam(@RequestParam Integer id){
        if (id == null){
            return "Wrong National Team ID";
        }
        nationalTeamService.deleteById(id);
        return "Deleted National Team";
    }

    @PostMapping(path = "/update")
    public String updateNationalTeam(@RequestParam Integer id,
                                     @RequestParam(required = false) String name,
                                     @RequestParam(required = false) Integer id_country,
                                     @RequestParam(required = false) Integer id_competition){

        NationalTeam nt = nationalTeamService.findById(id);
        if (nt.getId() == id){
            if (name != null){
                nt.setName(name);
            }
            if (id_country != null){
                Country country = new Country();
                country = countryService.findById(id_country);
                nt.setCountry(country);
            }
            if(id_competition != null){
                Competition competition = new Competition();
                competition = competitionService.findById(id_competition);
                nt.setCompetition(competition);
            }
            nationalTeamService.save(nt);
            return "Saved National Team";
        }
        return "Wrong National Team ID";
    }
}
