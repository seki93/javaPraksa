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
    private CityService cityService;

    @Autowired
    private PlayerStatsService playerStatsService;

    @Autowired
    private NationalTeamService nationalTeamService;

    @PostMapping(path = "/add")
    public String addNewPlayer(@RequestParam String firstName,
                               @RequestParam String lastName,
                                @RequestParam Date dateOfBirth,
                                @RequestParam String cityName,
                                @RequestParam String clubName,
                               @RequestParam String nationalTeamName,
                               @RequestParam String  positionName){

//        Player player = new Player(firstName, lastName, dateOfBirth, cityService.findByName(cityName),
//                positionService.findById(positionService.findByName(positionName)),
//                clubService.findById(clubService.findIdByName(clubName)),
//                nationalTeamService.findById(nationalTeamService.findIdByName(nationalTeamName))
//                );
//
//        playerService.save(player);
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
