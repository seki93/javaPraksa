package footstats.repository;

import footstats.model.ClubHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubHistoryRepository extends CrudRepository<ClubHistory, Integer> {


}
