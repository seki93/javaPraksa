package footstats.service;

import footstats.model.Game;

public interface GameService {
    public void deleteById(Integer id);
    public void save (Game game);
    public Iterable<Game> findAll();
    public Game findById(Integer id);
}
