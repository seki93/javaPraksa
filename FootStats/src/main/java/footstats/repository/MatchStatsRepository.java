package footstats.repository;

import footstats.model.MatchStats;
import org.springframework.data.repository.CrudRepository;

public interface MatchStatsRepository extends CrudRepository<MatchStats, Integer> {
}
