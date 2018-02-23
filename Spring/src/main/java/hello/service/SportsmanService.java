package hello.service;

import hello.model.Sportsman;

public interface SportsmanService {

	public Iterable<Sportsman> findAll();

	public void save(Sportsman s);

	public void deleteById(Integer id);

	public Sportsman findById(Integer id);

}
