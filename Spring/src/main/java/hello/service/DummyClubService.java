package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.Club;
import hello.repository.ClubRepository;

@Service("Dummy")
public class DummyClubService implements ClubService  {
	
	@Autowired
	private ClubRepository clubRepository;

	@Override
	public Iterable<Club> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Club c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Club findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Club findByName(String name) {
	
		Club c = new Club();
		c.setName("DummyClubName");
		
		return c;
	}

}
