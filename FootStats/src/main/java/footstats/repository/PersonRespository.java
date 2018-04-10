package footstats.repository;

import footstats.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRespository extends CrudRepository<Person, Integer> {

}
