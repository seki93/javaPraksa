package footstats.repository;

import footstats.model.Club;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends CrudRepository<Club, Integer> {

    @Query("select id from club c where c.name = ?1")
    public Integer findIdByName(String clubName);
}
