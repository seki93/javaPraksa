package hello.repos;

import org.springframework.data.repository.CrudRepository;

import hello.entity.Kompanija;


public interface KompanijaRepository extends CrudRepository<Kompanija, Integer> {

}