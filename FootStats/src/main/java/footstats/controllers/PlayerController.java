package footstats.controllers;

import footstats.model.*;
import footstats.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private PlayerStatsService playerStatsService;

    @Autowired
    private NationalTeamService nationalTeamService;

    @PostMapping(path = "/add")
    public String addNewPlayer(@RequestParam Integer club_id,
                               @RequestParam Integer nationalteam_id,
                               @RequestParam Integer person_id,
                               @RequestParam Integer playerstats_id,
                               @RequestParam Integer position_id){

        Player player = new Player();

        Club club = clubService.findById(club_id);
        player.setClub(club);

        NationalTeam nationalTeam = nationalTeamService.findById(nationalteam_id);
        player.setNationalTeam(nationalTeam);

        Person person = personService.findById(person_id);
        player.setPerson(person);

        PlayerStats playerStats = playerStatsService.findById(playerstats_id);
        player.setPlayerStats(playerStats);

        Position position = positionService.findById(position_id);
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
