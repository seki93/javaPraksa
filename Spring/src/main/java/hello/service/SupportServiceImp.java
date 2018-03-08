package hello.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.Support;
import hello.repository.SupportRepository;

@Service
public class SupportServiceImp implements SupportService {

	@Autowired
	private SupportRepository supportRepository;
	
	@Override
	public Iterable<Support> findAll() {
		
		return supportRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Support s) {
		
		supportRepository.save(s);
	}

}
