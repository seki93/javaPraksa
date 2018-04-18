package footstats.repository;

import footstats.model.Rank;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository extends CrudRepository<Rank, Integer>{

    @Query("select id from rank r where r.name = ?1")
    public Integer findIdByName(String rankName);
}
