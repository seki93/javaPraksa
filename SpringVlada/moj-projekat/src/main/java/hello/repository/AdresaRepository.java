package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.Adresa;

public interface AdresaRepository extends CrudRepository<Adresa, Integer> {

}