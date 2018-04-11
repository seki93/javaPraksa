package footstats.controllers;

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


}
