package footstats.repository;

import footstats.model.Referee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefereeRepository extends CrudRepository<Referee, Integer> {

    @Query("select id from referee r where r.firstName = ?1 and r.lastName = ?2")
    public Integer findIdbyName(String firstName, String lastName);
}
