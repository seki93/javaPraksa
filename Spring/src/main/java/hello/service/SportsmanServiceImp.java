package hello.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.Sportsman;

@Service
public class SportsmanServiceImp implements SportsmanService {

	@Autowired 
	private SportsmanService sportsmanService;
	
	@Override
	public Iterable<Sportsman> findAll() {
		
		Iterable<Sportsman> sportsmans = sportsmanService.findAll();
		
		if(sportsmans != null) {
			return sportsmans;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public void save(Sportsman s) {
		
		sportsmanService.save(s);
		
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		
		sportsmanService.deleteById(id);
		
	}

	@Override
	public Sportsman findById(Integer id) {
		
		Sportsman s = sportsmanService.findById(id);
		
		if(s != null) {
			return s;
		} else {
			return null;
		}
		
	}

}
