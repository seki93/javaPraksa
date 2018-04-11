package footstats.service;

import footstats.model.PlayerStats;

public interface PlayerStatsService {

    public void save(PlayerStats playerStats);

    public void deleteById(Integer id);

    public Iterable<PlayerStats> findAll();

    public PlayerStats findById(Integer id);
}
