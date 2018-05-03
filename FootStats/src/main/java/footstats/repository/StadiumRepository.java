package footstats.repository;

import footstats.model.Stadium;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StadiumRepository extends CrudRepository<Stadium, Integer> {

    public Stadium findByName(String stadiumName);

    public List<Stadium> findStadiumsByName(String name);
}
