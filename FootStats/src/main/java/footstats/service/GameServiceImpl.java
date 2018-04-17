package footstats.service;

import footstats.model.Game;
import footstats.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    GameRepository gameRepository;

    @Override
    @Transactional
    public void deleteById(Integer id) {
        gameRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(Game game) {
        gameRepository.save(game);
    }

    @Override
    public Iterable<Game> findAll() {

        Iterable<Game> g = gameRepository.findAll();

        if ( g != null){
            return g;
        } else {
            return null;
        }
    }

    @Override
    public Game findById(Integer id) {
        Game g = gameRepository.findOne(id);

        if(g != null){
            return g;
        } else {
            return null;
        }
    }
}
