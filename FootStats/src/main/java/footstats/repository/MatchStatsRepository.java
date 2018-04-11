package footstats.repository;

import footstats.model.MatchStats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchStatsRepository extends CrudRepository<MatchStats, Integer> {

    public void deleteById(Integer id);
}
