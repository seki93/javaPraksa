package footstats.controllers;

import footstats.model.PlayerStats;
import footstats.service.PlayerStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/playerstats")
public class PlayerStatsController {

    @Autowired
    private PlayerStatsService playerStatsService;

    @PostMapping(path = "/add")
    public String addNewPlayerStats(@RequestParam Integer assistance,
                                    @RequestParam Integer cards,
                                    @RequestParam Integer fouls,
                                    @RequestParam Integer goals,
                                    @RequestParam Integer passes){

        PlayerStats playerStats = new PlayerStats();
        playerStats.setAssistance(assistance);
        playerStats.setCards(cards);
        playerStats.setFouls(fouls);
        playerStats.setGoals(goals);
        playerStats.setPasses(passes);

        playerStatsService.save(playerStats);

        return "Saved PlayerStats";
    }
}
