package footstats.controllers;

import footstats.model.Country;
import footstats.model.Referee;
import footstats.service.CityService;
import footstats.service.CountryService;
import footstats.service.PersonService;
import footstats.service.RefereeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;

@RestController
@RequestMapping(path = "/referee")
public class RefereeController {

    @Autowired
    private RefereeService refereeService;

    @Autowired
    private PersonService personService;

    @Autowired
    private CountryService countryService;

    @GetMapping(path = "/all")
    public Iterable<Referee> findAll(){
        return refereeService.findAll();
    }

    @PostMapping(path = "/add")
    public String addReferee(@RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam Date dateOfBirth,
                             @RequestParam String countryName) {
        Referee referee = new Referee();
        referee.setFirstName(firstName);
        referee.setLastName(lastName);
        referee.setDateOfBirth(dateOfBirth);

        Country country = countryService.findIdByName(countryName);
        referee.setCountryOfBirth(country);

        refereeService.save(referee);

        return "Saved new referee";
    }

    @PostMapping(path = "/delete")
    public String deleteReferee(@RequestParam Integer id){

        if(id == null) return "No referee with this id";

        refereeService.deleteById(id);
        return "Deleted referee";
    }
}
