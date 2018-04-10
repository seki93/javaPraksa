package footstats.repository;

import footstats.model.PlayerStats;
import org.springframework.data.repository.CrudRepository;

public interface PlayerStatsRepository extends CrudRepository<PlayerStats, Integer> {
    
}
