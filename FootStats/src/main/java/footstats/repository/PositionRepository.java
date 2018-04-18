package footstats.repository;

import footstats.model.Position;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CrudRepository<Position, Integer> {

    @Query("select id from position p where p.name = ?1")
    public Integer findByName(String positionName);
}
