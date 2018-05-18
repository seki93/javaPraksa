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

import java.util.HashSet;

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
                             @RequestParam String cityName,
                             @RequestParam String competitionName,
                             @RequestParam String stadiumName){

        Club club = new Club();
        if(name == "" || name == null || name.isEmpty()) return "No name";
        club.setName(name);
        City city = cityService.findByName(cityName);
        if(city == null) return "Wrong city";
        club.setCity(city);

        Competition competition = competitionService.findByName(competitionName);
        if(competition == null) return "No competition with that name";
        club.setCompetitionSet(new HashSet<>());
        club.addCompetition(competition);

        Stadium stadium = stadiumService.findByName(stadiumName);
        if(stadium == null) return "No stadium with tath name";
        club.setStadium(stadium);

        clubService.save(club);
        return "Saved Club";

    }

    @PostMapping(path = "/delete")
    public String deleteClub(@RequestParam String name){
        Club c = clubService.findByName(name);

        if(c.getId() == null){
            return "Wrong club id";
        }

        clubService.deleteById(c.getId());
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
