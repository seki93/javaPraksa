package footstats.controllers;

import footstats.dataImport.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/import")
public class ImportController {

    @Autowired
    private CityImport cityImport;

    @Autowired
    private CountryImport countryImport;

    @Autowired
    CompetitionImport competitionImport;

    @Autowired
    StadiumImport stadiumImport;

    @Autowired
    PositionImport positionImport;

    @Autowired
    ClubImport clubImport;

    @Autowired
    GameImport gameImport;

    @GetMapping(path = "/game")
    public String importGames(){
        try {
            gameImport.importGames();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return "Success with games imports";
    }

    /*@Autowired
    RefereeImport refereeImport;

    @GetMapping(path = "/refeere")
    public String importReferees() {
        try {
            refereeImport.importReferees();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Success with import referees";
    }*/

    @GetMapping(path = "/city")
    public String importCities(){
        try {
            cityImport.importCities();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Success with import cities";
    }

    @GetMapping(path = "/country")
    public String importCountries() {
        try{
            countryImport.importCountries();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Success with import countries!";
    }

    @GetMapping(path = "/competition")
    public String importCompetitions() {
        try{
            competitionImport.importCompetitions();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Success with import competitions!";
    }

    @GetMapping(path = "/position")
    public String importPositions() {
        try{
            positionImport.importPositions();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Success with import positions!";
    }

    @GetMapping(path = "/stadium")
    public String importStadiums() {
        try{
            stadiumImport.importStadiums();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Success with import stadiums!";
    }

    @GetMapping(path = "/club")
    public String importClubs(){
        clubImport.importClubs();

        return "Success";
    }
}
