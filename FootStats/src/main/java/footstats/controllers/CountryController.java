package footstats.controllers;

import footstats.model.Country;
import footstats.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping(path = "/all")
    public Iterable<Country> getAllCountry(){
        return countryService.findAll();
    }

    @PostMapping(path = "/add")
    public String addNewCountry(@RequestParam String name,
                                @RequestParam String countryCode){
        Country c = new Country();
        c.setName(name);
        c.setCountryCode(countryCode);
        countryService.save(c);
        return "Added Country";
    }

    @PostMapping(path = "/delete")
    public String deleteCountry(@RequestParam String name){
        Country c = countryService.findByName(name);

        if (c.getId() == null)
            return "Wrong Country ID";
        countryService.deleteById(c.getId());
        return "Deleted Country";
    }

    @PostMapping(path = "/update")
    public String updateCountry(@RequestParam String name,
                                @RequestParam String countryCode){
        Country c = countryService.findByName(name);

        if (c.getCountryCode() != countryCode){
            c.setCountryCode(countryCode);
            countryService.save(c);
            return "Updated Country";
        }
        return "Nothing to update";
    }
}
