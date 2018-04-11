package footstats.service;

import footstats.model.Country;
import footstats.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CountryServiceImp implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    @Transactional
    public void deleteById(Integer id) {
        countryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(Country country) {
        countryRepository.save(country);

    }

    @Override
    public Iterable<Country> findAll() {

        return countryRepository.findAll();
    }

    @Override
    public Country findById(Integer id) {
        Country c = countryRepository.findOne(id);

        if(c != null){
            return c;
        } else {
            return null;
        }
    }
}
