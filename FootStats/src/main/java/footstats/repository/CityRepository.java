package footstats.repository;

import footstats.model.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

    public City findByName(String cityName);

    @Query(value = "SELECT EXISTS (SELECT 1 FROM city WHERE name = ?1", nativeQuery = true)
    String checkIfExists(String name);
}
