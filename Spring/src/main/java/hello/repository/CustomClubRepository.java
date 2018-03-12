package hello.repository;

import hello.model.Club;

public interface CustomClubRepository<Club, String> {
	
	public Club findByName(String name);

}
