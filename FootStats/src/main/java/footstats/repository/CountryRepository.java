package footstats.repository;

import footstats.model.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

    public void deleteById(Integer id);

    public Country findByName(String countryName);
}
