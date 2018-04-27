package footstats.service;

import footstats.model.City;
import footstats.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        Iterable<City> cities = cityRepository.findAll();

        if(cities != null) return  cities;
        else return null;
    }

    @Override
    public City findById(Integer id) {
        City c = cityRepository.findOne(id);

        if(c != null) return c;
        else return null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        cityRepository.delete(id);
    }

    @Override
    @Transactional
    public void save(City c) {
        cityRepository.save(c);
    }

    @Override
    public City findByName(String cityName) {
        return cityRepository.findByName(cityName);
    }

    @Override
    public String checkIfExists(String name) {
        return cityRepository.checkIfExists(name);
    }
}
