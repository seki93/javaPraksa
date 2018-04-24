package footstats.controllers;

import footstats.model.Country;
import footstats.model.Person;
import footstats.service.CityService;
import footstats.service.CountryService;
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
    private CountryService countryService;

    @PostMapping(path = "/add")
    public String addNewPerson(@RequestParam Date date,
                               @RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String countryName){

        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setDateOfBirth(date);
        Country country = countryService.findByName(countryName);
        person.setCountryOfBirth(country);

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
