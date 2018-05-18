package footstats.controllers;

import footstats.model.Competition;
import footstats.model.Country;
import footstats.model.NationalTeam;
import footstats.service.CompetitionService;
import footstats.service.CountryService;
import footstats.service.NationalTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Iterable<NationalTeam> getAllNationalTeam() {
        return nationalTeamService.findAll();
    }

    @PostMapping(path = "/add")
    public String addNewNationalTeam(@RequestParam String name) {

        NationalTeam nationalTeam = new NationalTeam();
        nationalTeam.setName(name);

        Country country = countryService.findByName(name);
        nationalTeam.setCountry(country);

        nationalTeamService.save(nationalTeam);
        return "Saved National Team";
    }

    @PostMapping(path = "/delete")
    public String deleteNationalTeam(@RequestParam String name) {
        NationalTeam nationalTeam = nationalTeamService.findByName(name);

        if (nationalTeam.getId() == null) {
            return "Wrong National Team ID";
        }
        nationalTeamService.deleteById(nationalTeam.getId());
        return "Deleted National Team";
    }

    @PostMapping(path = "/update")
    public String updateNationalTeam(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) String competitionName) {

        NationalTeam nationalTeam = nationalTeamService.findByName(name);
        nationalTeam.addCompetition(competitionService.findByName(competitionName));

        nationalTeamService.save(nationalTeam);

        return "Saved National Team";
    }

    @GetMapping(path = "/getNationalTeamByNames")
    public List<NationalTeam> getNationalTeamByNames(@RequestParam String name) {

        List<NationalTeam> nationalTeams = nationalTeamService.findNationalTeamByName(name);
        if(nationalTeams != null) return nationalTeams;

        return null;

    }
}
