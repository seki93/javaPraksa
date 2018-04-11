package footstats.service;

import footstats.model.Player;

public interface PlayerService {

    public void save(Player player);

    public void deleteById(Integer id);

    public Iterable<Player> findAll();

    public Player findById(Integer id);
}
