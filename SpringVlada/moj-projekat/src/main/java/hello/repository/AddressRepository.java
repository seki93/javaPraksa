package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

	public void deleteById(Integer id);
	
}