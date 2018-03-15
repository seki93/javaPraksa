package hello.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import hello.model.Sportsman;

public interface SportsmanService {

	public Iterable<Sportsman> findAll();

	public void save(Sportsman s);

	public void deleteById(Integer id);

	public Sportsman findById(Integer id);
	
	public List<Sportsman> findByRank(Integer rank);
	
	public List<Sportsman> findByLastName(String lastName, Pageable pageable);

}
