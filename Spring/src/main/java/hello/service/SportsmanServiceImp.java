package hello.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.Sportsman;
import hello.repository.SportsmanRepository;

@Service
public class SportsmanServiceImp implements SportsmanService {

	@Autowired 
	SportsmanRepository sportsmanRepository;
	
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
		
		Sportsman s = sportsmanRepository.findOne(id);
		
		if(s != null) {
			return s;
		} else {
			return null;
		}
		
	}

	@Override
	public List<Sportsman> findByRank(Integer rank) {
		List<Sportsman> s = sportsmanRepository.findByRank(rank);
		
		if(s != null) {
			return s;
		} else {
			return null;	
		}
		
	}

}
