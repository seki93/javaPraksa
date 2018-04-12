package footstats.controllers;

import footstats.model.ClubHistory;
import footstats.model.Player;
import footstats.service.ClubHistoryService;
import footstats.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/clubhistory")
public class ClubHistoryController {

    @Autowired
    private ClubHistoryService clubHistoryService;

    @Autowired
    private PlayerService playerService;

    @PostMapping(path = "/add")
    public String addNewClubHistory(@RequestParam Integer player_id){

        ClubHistory clubHistory = new ClubHistory();

        Player player = playerService.findById(player_id);
        clubHistory.setPlayer(player);

        clubHistoryService.save(clubHistory);
        return "ClubHistory saved";
    }

    @DeleteMapping(path = "/delete")
    public String deleteClubHisory(@RequestParam Integer id){

        if(id == null){

            return "Wrong clubHistory id";
        }

        clubHistoryService.deleteById(id);
        return "ClubHistory deleted";
    }

    @GetMapping(path = "/all")
    public Iterable<ClubHistory> getAllClubHistories(){

        return clubHistoryService.findAll();
    }

}
