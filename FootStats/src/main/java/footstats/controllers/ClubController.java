package footstats.controllers;

import footstats.model.City;
import footstats.model.Club;
import footstats.model.Competition;
import footstats.model.Stadium;
import footstats.service.CityService;
import footstats.service.ClubService;
import footstats.service.CompetitionService;
import footstats.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/club")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private CityService cityService;

    @Autowired
    private StadiumService stadiumService;

    @PostMapping(path = "/add")
    public String addNewClub(@RequestParam String name,
                             @RequestParam Integer city_id,
                             @RequestParam Integer competition_id,
                             @RequestParam Integer stadium_id){

        Club club = new Club();
        club.setName(name);
        City city = cityService.findById(city_id);
        club.setCity(city);
        Competition competition = competitionService.findById(competition_id);
        club.setCompetition(competition);
        Stadium stadium = stadiumService.findById(stadium_id);
        club.setStadium(stadium);

        clubService.save(club);
        return "Saved Club";

    }

    @DeleteMapping(path = "/delete")
    public String deleteClub(@RequestParam Integer id){

        if(id == null){

            return "Wrong club id";
        }

        clubService.deleteById(id);
        return "Club deleted";
    }

    @GetMapping(path = "/all")
    public Iterable<Club> getAllClubs(){

        return clubService.findAll();
    }

    /*@PostMapping(path = "/update")
    public String updateClub(@RequestParam Integer id,
                             @RequestParam (required = false) String name,
                             @RequestParam (required = false) Integer competition_id,
                             @RequestParam (required = false) Integer city_id,
                             @RequestParam (required = false) Integer stadium_id){

        Club club = clubService.findById(id);
        if(club.getId() == id){

        }

    }*/
}
