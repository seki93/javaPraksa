package hello.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import hello.model.Aspekt;
import hello.repository.AspektRepository;

public class AspektServiceImp implements AspektService {
	
	@Autowired
	AspektRepository aspektRepository;

	@Override
	@Transactional
	public void save(Aspekt aspect) {
		
		aspektRepository.save(aspect);		
	}

}
