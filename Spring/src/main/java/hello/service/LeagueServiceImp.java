package hello.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.League;
import hello.repository.LeagueRepository;

@Service
public class LeagueServiceImp implements LeagueService {

	@Autowired
	LeagueRepository leagueRepository;
	
	@Override
	@Transactional
	public void deleteById(Integer id) {
		leagueRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void save(League league) {
		leagueRepository.save(league);
	}

	@Override
	public Iterable<League> findAll() {
		Iterable<League> league = leagueRepository.findAll();
		
		if(league != null) {
			return league;
		} else {
			return null;
		}
	}

	@Override
	public League findById(Integer id) {
		League l = leagueRepository.findOne(id);
		
		if(l != null) {
			return l;
		} else {
			return null;
		}
	}

	
}
