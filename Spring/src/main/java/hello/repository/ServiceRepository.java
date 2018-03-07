package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.Service;

public interface ServiceRepository extends CrudRepository<Service, String> {
	
	public void deleteByName(String name);

}
