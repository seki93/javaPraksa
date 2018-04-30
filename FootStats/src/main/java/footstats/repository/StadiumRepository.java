package footstats.repository;

import footstats.model.Stadium;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends CrudRepository<Stadium, Integer> {

    public Stadium findByName(String stadiumName);

    public Iterable<Stadium> findStadiumsByName(String name);
}
