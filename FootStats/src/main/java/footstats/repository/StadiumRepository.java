package footstats.repository;

import footstats.model.Stadium;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends CrudRepository<Stadium, Integer> {

    @Query("select id from stadium s where s.name = ?1")
    public Integer findIdByName(String stadiumName);
}
