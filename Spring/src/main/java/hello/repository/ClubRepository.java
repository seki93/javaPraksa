package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.Club;

public interface ClubRepository extends CrudRepository<Club, Integer> {

	public void deleteById(Integer id);
	
}
