package footstats.repository;

import footstats.model.Competition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends CrudRepository<Competition, Integer> {

    public void deleteById(Integer id);

    public Competition findByName(String competitionName);

}
