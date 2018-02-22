package hello.repos;

import org.springframework.data.repository.CrudRepository;

import hello.entity.Adresa;

public interface AdresaRepository extends CrudRepository<Adresa, Integer> {

}