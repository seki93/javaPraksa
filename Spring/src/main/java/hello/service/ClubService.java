package hello.service;

import hello.model.Club;

public interface ClubService {

	public Iterable<Club> findAll();

	public void save(Club c);

	public void deleteById(Integer id);

	public Club findById(Integer id);

}
