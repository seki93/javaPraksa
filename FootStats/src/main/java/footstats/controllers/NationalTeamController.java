package footstats.controllers;

import footstats.service.CompetitionService;
import footstats.service.CountryService;
import footstats.service.NationalTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    
}
