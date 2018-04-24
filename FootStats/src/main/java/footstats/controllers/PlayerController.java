package footstats.controllers;

import footstats.model.*;
import footstats.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping(path = "/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PersonService personService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private ClubService clubService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private PlayerStatsService playerStatsService;

    @Autowired
    private NationalTeamService nationalTeamService;

    @PostMapping(path = "/add")
    public String addNewPlayer(@RequestParam String firstName,
                               @RequestParam String lastName,
                                @RequestParam Date dateOfBirth,
                                @RequestParam String countryName,
                                @RequestParam String clubName,
                               @RequestParam String nationalTeamName,
                               @RequestParam String  positionName){

       Player player = new Player();
       player.setFirstName(firstName);
       player.setLastName(lastName);
       player.setDateOfBirth(dateOfBirth);

       Country country = countryService.findByName(countryName);
       player.setCountryOfBirth(country);

       Club club = clubService.findByName(clubName);
       player.setClub(club);

       NationalTeam nationalTeam = nationalTeamService.findByName(nationalTeamName);
       player.setNationalTeam(nationalTeam);

       Position position = positionService.findByName(positionName);
       player.setPosition(position);

       playerService.save(player);


        return "Player saved";

    }

    @DeleteMapping(path = "/delete")
    public String deletePlayer(@RequestParam Integer id){
        if(id == null){
            return "Wrong player id";
        }

        playerService.deleteById(id);
        return "Player deleted";
    }

    @GetMapping(path = "/all")
    public Iterable<Player> getAllPlayers(){
        return playerService.findAll();
    }
}
