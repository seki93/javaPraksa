package footstats.repository;

import footstats.model.Club;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends CrudRepository<Club, Integer> {


}
