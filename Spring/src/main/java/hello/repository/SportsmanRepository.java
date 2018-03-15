package hello.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import hello.model.Sportsman;

public interface SportsmanRepository extends CrudRepository<Sportsman, Integer>{

	public void deleteById(Integer id);
	
	@Query("select DISTINCT s from Sportsman s where s.club.league.rank = ?1")
    public List<Sportsman> findByRank(Integer rang);
	
	public List<Sportsman> findByLastName(String lastName, Pageable pageable);
}
