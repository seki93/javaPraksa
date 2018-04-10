package footstats.repository;

import footstats.model.Competition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends CrudRepository<Competition, Integer> {
}
