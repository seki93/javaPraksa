package hello.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import hello.model.Service;
import hello.repository.ServiceRepository;

public class ServiceServiceImp implements ServiceService{
	
	@Autowired
	ServiceRepository serviceRepository;

	@Override
	@Transactional
	public void save(Service service) {

		serviceRepository.save(service);
		
	}

}
