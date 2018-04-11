package footstats.controllers;

import footstats.model.Rank;
import footstats.repository.RankRepository;
import footstats.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rank")
public class RankController {

    @Autowired
    private RankService rankService;

    @GetMapping(path = "/all")
    public Iterable<Rank> findAll(){
        return rankService.findAll();
    }

    @PostMapping(path = "/add")
    public String addRank(@RequestParam String name){
        Rank rank = new Rank();
        rank.setName(name);

        rankService.save(rank);

        return "Saved new rank";
    }

    @PostMapping(path = "/delete")
    public String delete(@RequestParam Integer id){
        if(id == null) return "Wrong id";

        rankService.deleteById(id);
        return "Deleted rank";
    }

}
