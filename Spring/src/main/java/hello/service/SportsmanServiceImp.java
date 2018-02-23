package hello.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.Sportsman;

@Service
public class SportsmanServiceImp implements SportsmanRepository {

	@Autowired 
	private SportsmanRepository sportsmanRepository;
	
	@Override
	public Iterable<Sportsman> findAll() {
		
		Iterable<Sportsman> sportsmans = sportsmanRepository.findAll();
		
		if(sportsmans != null) {
			return sportsmans;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public void save(Sportsman s) {
		
		sportsmanRepository.save(s);
		
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		
		sportsmanRepository.deleteById(id);
		
	}

	@Override
	public Sportsman findById(Integer id) {
		
		Sportsman s = sportsmanRepository.findById(id);
		
		if(s != null) {
			return s;
		} else {
			return null;
		}
		
	}

}
