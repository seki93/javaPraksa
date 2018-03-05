package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.Aspekt;

public interface AspektRepository extends CrudRepository<Aspekt, Integer> {

	public void deleteById(Integer id);
	
}
