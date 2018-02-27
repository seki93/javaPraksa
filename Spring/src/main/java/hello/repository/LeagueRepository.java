package hello.repository;


import org.springframework.data.repository.CrudRepository;

import hello.model.League;

public interface LeagueRepository extends CrudRepository<League, Integer> {
	
	public void deleteById(Integer id);
	

}
