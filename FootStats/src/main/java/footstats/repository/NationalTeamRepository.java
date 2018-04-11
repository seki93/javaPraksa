package footstats.repository;

import footstats.model.NationalTeam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationalTeamRepository extends CrudRepository<NationalTeam, Integer> {

    public void deleteById(Integer id);
}
