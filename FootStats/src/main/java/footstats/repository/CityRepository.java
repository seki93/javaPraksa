package footstats.repository;

import footstats.model.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

    @Query("select id from city c where c.name = ?1")
    public Integer findIdByName(String cityName);
}
