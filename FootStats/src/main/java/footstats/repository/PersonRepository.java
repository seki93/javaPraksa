package footstats.repository;

import footstats.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("select id from Person p where p.firstName = ?1 and p.lastName = ?2")
    public Integer findByName(String firstName, String lastName);

}
