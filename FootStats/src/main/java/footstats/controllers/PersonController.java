package footstats.controllers;

import footstats.model.City;
import footstats.model.Person;
import footstats.service.CityService;
import footstats.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(path = "/delete")
    public String deletePerson(@RequestParam Integer id){

        if(id == null){

            return "Wrong person id";
        }

        personService.deleteById(id);
        return "Person deleted";

    }

    @GetMapping(path = "/all")
    public Iterable<Person> getAllPersons(){

        return personService.findAll();
    }

}
