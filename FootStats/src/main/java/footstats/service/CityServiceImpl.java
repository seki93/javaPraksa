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
        return null;
    }

    @Override
    public City findById(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {

    }

    @Override
    @Transactional
    public void save(City c) {

    }
}
