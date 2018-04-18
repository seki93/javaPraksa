package footstats.service;

import footstats.model.Country;

public interface CountryService {

    public void deleteById(Integer id);
    public void save(Country country);
    public Iterable<Country> findAll();
    public Country findById(Integer id);

    public Integer findIdByName(String countryName);
}
