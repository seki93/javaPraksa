package hello.service;


import hello.model.League;

public interface LeagueService {
	
public void deleteById(Integer id);
	
	public void save(League league);

	public Iterable<League> findAll();

	public League findById(Integer id);

}
