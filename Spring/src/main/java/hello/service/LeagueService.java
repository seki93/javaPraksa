package hello.service;

import java.util.List;

import hello.model.League;
import hello.model.Sportsman;

public interface LeagueService {
	
public void deleteById(Integer id);
	
	public void save(League league);

	public Iterable<League> findAll();

	public League findById(Integer id);

}
