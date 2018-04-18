package footstats.repository;

import footstats.model.Competition;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends CrudRepository<Competition, Integer> {

    public void deleteById(Integer id);

    @Query("select id from competition c where c.name = ?1")
    public Integer findIdByName(String competitionName);

}
