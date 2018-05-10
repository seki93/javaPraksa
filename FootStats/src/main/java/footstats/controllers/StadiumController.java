package footstats.controllers;

import footstats.model.Stadium;
import footstats.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/stadium")
public class StadiumController {

    @Autowired
    private StadiumService stadiumService;

    @GetMapping(path = "/all")
    public Iterable<Stadium> findAll(){
        return  stadiumService.findAll();
    }

    @PostMapping(path = "/add")
    public String addStadium(@RequestParam String name){
        Stadium s = new Stadium();
        s.setName(name);

        stadiumService.save(s);

        return "Saved new stadium";
    }

    @PostMapping(path = "/delete")
    public String deleteStadium(@RequestParam String name){
        Stadium s = stadiumService.findByName(name);

        if(s.getId() == null) return "Wrong id";

        stadiumService.deleteById(s.getId());
        return "Deleted stadium";
    }
}
