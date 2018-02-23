package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.Sportsman;

public interface SportsmanRepository extends CrudRepository<Sportsman, Integer>{

	public void deleteById(Integer id);
	
}
