package hello.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.Club;

@Service
public class ClubServiceImp implements ClubRepository {

	@Autowired
	public ClubRepository clubRepository;
	
	@Override
	public Iterable<Club> findAll() {
		
		Iterable<Club> clubs = clubRepository.findAll();
		
		if(clubs != null) {
			return clubs;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public void save(Club c) {
		
		clubRepository.save(c);
		
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		
		clubRepository.deleteById(id);
		
	}

	@Override
	public Club findById(Integer id) {
		
		Club c = clubRepository.findById(id);
		
		if(c != null) {
			return c;
		} else {
			return null;
		}
	}

}
