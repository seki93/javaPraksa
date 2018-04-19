package footstats.controllers;

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
                               @RequestParam String cityName){

        Person person = new Person(firstName, lastName, date,
                cityService.findByName(cityName));

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
