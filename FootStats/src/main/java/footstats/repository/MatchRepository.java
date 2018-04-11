package footstats.repository;

import footstats.model.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends CrudRepository<Match, Integer> {

    public void deleteById(Integer id);
}
