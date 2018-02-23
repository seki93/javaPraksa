package hello.service;

import hello.model.Sportsman;

public interface SportsmanService {

	Iterable<Sportsman> findAll();

	void save(Sportsman s);

	void deleteById(Integer id);

	Sportsman findById(Integer id);

}
