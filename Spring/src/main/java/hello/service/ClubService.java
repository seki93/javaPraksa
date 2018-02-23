package hello.service;

import hello.model.Club;

public interface ClubService {

	Iterable<Club> findAll();

	void save(Club c);

	void deleteById(Integer id);

	Club findById(Integer id);

}
