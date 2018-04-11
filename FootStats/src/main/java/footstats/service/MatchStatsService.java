package footstats.service;

import footstats.model.MatchStats;

public interface MatchStatsService {
    public void deleteById(Integer id);
    public void save (MatchStats matchStats);
    public Iterable<MatchStats> findAll();
    public MatchStats findById(Integer id);
}
