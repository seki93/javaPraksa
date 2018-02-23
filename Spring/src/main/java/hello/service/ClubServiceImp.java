package hello.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import hello.model.Club;

public class ClubServiceImp implements ClubService {

	@Autowired
	public ClubService clubService;
	
	@Override
	public Iterable<Club> findAll() {
		
		Iterable<Club> clubs = clubService.findAll();
		
		if(clubs != null) {
			return clubs;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public void save(Club c) {
		
		clubService.save(c);
		
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		
		clubService.deleteById(id);
		
	}

	@Override
	public Club findById(Integer id) {
		
		Club c = clubService.findById(id);
		
		if(c != null) {
			return c;
		} else {
			return null;
		}
	}

}
