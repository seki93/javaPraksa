package footstats.controllers;

import footstats.dataImport.*;
import footstats.model.Position;
import footstats.model.Rank;
import footstats.model.Stadium;
import footstats.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/import")
public class ImportController {

    @Autowired
    private CityService cityService;
    @Autowired
    private CityImport cityImport;

    @Autowired
    private CountryService countryService;
    @Autowired
    private CountryImport countryImport;

    @Autowired
    CompetitionService competitionService;
    @Autowired
    CompetitionImport competitionImport;

    @Autowired
    StadiumService stadiumService;
    @Autowired
    StadiumImport stadiumImport;

    @Autowired
    PositionService positionService;
    @Autowired
    PositionImport positionImport;

    @GetMapping(path = "/city")
    public String importCities(){
        try {
            cityImport.importCities();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Success";
    }

    @GetMapping(path = "/country")
    public String importCountries() {
        try{
            countryImport.importCountries();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Success!";
    }

    @GetMapping(path = "/competition")
    public String importCompetitions() {
        try{
            competitionImport.importCompetitions();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Success!";
    }

    @GetMapping(path = "/position")
    public String importPositions() {
        try{
            positionImport.importPositions();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Success!";
    }

    @GetMapping(path = "/stadium")
    public String importStadiums() {
        try{
            stadiumImport.importStadiums();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Success!";
    }
}
