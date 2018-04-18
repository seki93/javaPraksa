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
    public String deleteCountry(@RequestParam Integer id){
        if (id == null)
            return "Wrong Country ID";
        countryService.deleteById(id);
        return "Deleted Country";
    }

    @PostMapping(path = "/update")
    public String updateCountry(@RequestParam Integer id,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) String countryCode){
        Country c = new Country();
        if (c.getId() == id){
           if ( name != null) {
               c.setName(name);
           }
           if ( countryCode != null){
               c.setCountryCode(countryCode);
           }

            countryService.save(c);
            return "Updated Country";
        }
        return "Wrong Country ID";
    }
}
