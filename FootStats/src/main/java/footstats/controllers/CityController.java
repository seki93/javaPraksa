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
    public String addCity(@RequestParam String name,
                          @RequestParam String countryName){
        City city = new City();
        if(name == "" || name == null || name.isEmpty()) return "No city name";
        city.setName(name);

        Country country = countryService.findByName(countryName);

        if(country == null) return "No country with that name";
        city.setCountry(country);

        cityService.save(city);
        return "Saved new city";
    }

    @PostMapping(path = "/delete")
    public String delete(@RequestParam String name){
        City c = cityService.findByName(name);

        if(c.getId() == null) return "Wrong name";

        cityService.deleteById(c.getId());
        return "Deleted city";
    }

    @GetMapping(path = "/findByName")
    public City findByname(@RequestParam String name){
        City c = cityService.findByName(name);
        return  c;
    }


}
