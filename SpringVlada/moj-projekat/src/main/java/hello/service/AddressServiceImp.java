package hello.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import hello.repository.AddressRepository;

public class AddressServiceImp implements AddressService{

	@Autowired
	AddressRepository addressRepository;

	@Override
	@Transactional
	public void deleteById(Integer id) {
		
		addressRepository.deleteById(id);
		
	}
	
	
	
}
