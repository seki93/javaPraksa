package footstats.repository;

import footstats.model.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

    public void deleteById(Integer id);

    @Query("select id from cuntry c where c.name=?1")
    public Integer findIdByName(String countryName);

}
