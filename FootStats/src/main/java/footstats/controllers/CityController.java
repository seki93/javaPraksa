package footstats.controllers;

import footstats.model.City;
import footstats.model.Country;
import footstats.service.CityService;
import footstats.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @GetMapping(path = "/all")
    public Iterable<City> findAll(){
        return cityService.findAll();
    }

    @PostMapping(path = "/add")
    public String addCity(@RequestParam String name, @RequestParam Integer id_country){
        City city = new City();
        city.setName(name);
        Country country = countryService.findById(id_country);

        if(country == null) return "No country with that id";

        city.setCountry(country);
        cityService.save(city);
        return "Saved new city";
    }

    @PostMapping(path = "/delete")
    public String delete(@RequestParam Integer id){
        if(id == null) return "Wrong id";

        cityService.deleteById(id);
        return "Deleted city";
    }
}
