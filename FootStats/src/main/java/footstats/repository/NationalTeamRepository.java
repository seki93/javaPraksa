package footstats.repository;

import footstats.model.NationalTeam;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NationalTeamRepository extends CrudRepository<NationalTeam, Integer> {

    public void deleteById(Integer id);

    @Query("select id from nationalteam nt where nt.name = ?1")
    public Integer findIdByName(String nationalTeamNme);
}
