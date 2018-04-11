package footstats.service;

import footstats.model.City;

public interface CityService {

    public Iterable<City> findAll();

    public City findById(Integer id);

    public void deleteById(Integer id);

    public void save(City c);
}
