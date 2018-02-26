package hello.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import hello.model.League;
import hello.model.Sportsman;

public interface LeagueRepository extends CrudRepository<League, Integer> {
	
	public void deleteById(Integer id);
	

}
