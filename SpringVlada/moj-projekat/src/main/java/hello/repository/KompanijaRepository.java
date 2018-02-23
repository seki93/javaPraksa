package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.Kompanija;


public interface KompanijaRepository extends CrudRepository<Kompanija, Integer> {
	
	public void deleteById(Integer kompanija_id);
	
}