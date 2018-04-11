package footstats.service;

import footstats.model.Match;

public interface MatchService {
    public void deleteById(Integer id);
    public void save (Match match);
    public Iterable<Match> findAll();
    public Match findById(Integer id);
}
