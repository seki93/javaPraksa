package hello.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.Address;
import hello.repository.AddressRepository;

@Service
public class AddressServiceImp implements AddressService{

	@Autowired
	AddressRepository addressRepository;

	@Override
	@Transactional
	public void deleteById(Integer id) {
		
		addressRepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void save(Address address) {
		
		addressRepository.save(address);
		
	}

	public Iterable<Address> findAll() {
		
		return addressRepository.findAll();
	}

	@Override
	public Address findById(Integer id) {
		
		Address a = addressRepository.findOne(id);
		
		if(a != null) {
			return a;
		} else {
			return a;
		}
		
	}	
	
}
