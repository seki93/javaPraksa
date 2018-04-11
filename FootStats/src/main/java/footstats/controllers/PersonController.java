package footstats.controllers;

import footstats.model.City;
import footstats.model.Person;
import footstats.service.CityService;
import footstats.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private CityService cityService;

    @PostMapping(path = "/add")
    public String addNewPerson(@RequestParam Date date,
                               @RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam Integer city_id){

        Person person = new Person();
        person.setDateOfBirth(date);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        City city = cityService.findById(city_id);
        person.setCityOfBirth(city);

        personService.save(person);
        return "Person saved";
    }

}
