package hello.repos;

import org.springframework.data.repository.CrudRepository;

import hello.entity.Radnik;


	public interface RadnikRepository extends CrudRepository<Radnik, Integer> {

	}

