package footstats.controllers;

import footstats.model.City;
import footstats.model.Country;
import footstats.model.Person;
import footstats.model.Referee;
import footstats.service.CityService;
import footstats.service.CountryService;
import footstats.service.PersonService;
import footstats.service.RefereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/referee")
public class RefereeController {

    @Autowired
    private RefereeService refereeService;

    @Autowired
    private PersonService personService;

    @GetMapping(path = "/all")
    public Iterable<Referee> findAll(){
        return refereeService.findAll();
    }

    @PostMapping(path = "/add")
    public String addReferee(@RequestParam Integer id){
        Referee r = new Referee();
        Person p = new Person();

        p.setId(id);

        r.setPerson(p);
        refereeService.save(r);

        return "Saved new referee";
    }

    @PostMapping(path = "/delete")
    public String deleteReferee(@RequestParam Integer id){

        if(id == null) return "No referee with this id";

        refereeService.deleteById(id);
        return "Deleted referee";
    }
}
