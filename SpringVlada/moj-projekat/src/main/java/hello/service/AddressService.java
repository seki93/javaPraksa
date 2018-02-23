package hello.service;

import hello.model.Address;

public interface AddressService {

	public void deleteById(Integer id);
	
	public void save(Address address);

	public Iterable<Address> findAll();

	public Address findById(Integer id);
	
}
