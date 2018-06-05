package footstats.service;

import footstats.model.Club;
import footstats.model.Game;
import footstats.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Override
    public List<Game> findAllMatch(String clubName) {
        List<Game> games = gameRepository.findAllMatch(clubName);

        if(games.size() == 0) return null;
        else return games;
    }

    @Override
    public List<Game> findWinHome(String clubName,Pageable pageable) {
        List<Game> games = gameRepository.findWinHome(clubName, pageable);

        if(games.size() == 0) return null;
        else  return games;
    }

    @Override
    public List<Game> findNNumbersOfWinAtHome(String clubName, Integer number) {
        List<Game> games = gameRepository.findNNumbersOfWinAtHome(clubName, number);

        if(games.size() == 0) return null;
        else return games;
    }

    @Override
    public List<Game> findDrawnAtHome(String clubName, Pageable pageable) {
        List<Game> games = gameRepository.findDrawnAtHome(clubName, pageable);

        if(games.size() == 0) return null;
        else return games;
    }

    @Override
    public List<Game> findNNumbersOfDrawnAtHome(String clubName, Integer number) {
        List<Game> games = gameRepository.findNNumbersOfDrawnAtHome(clubName, number);

        if(games.size() == 0) return null;
        else return games;
    }

    @Override
    public List<Game> findLostAtHome(String clubName, Pageable pageable) {
        List<Game> games = gameRepository.findLostAtHome(clubName, pageable);

        if(games.size() == 0) return null;
        else return games;
    }

    @Override
    public List<Game> findNLostAtHome(String clubName, Integer number) {
        List<Game> games = gameRepository.findNLostAtHome(clubName, number);

        if(games.size() == 0) return null;
        else return games;
    }

    @Override
    public List<Game> findAllLostAway(String clubName, Pageable pageable) {
        List<Game> games = gameRepository.findAllLostAway(clubName, pageable);

        if(games.size() == 0) return null;
        else return games;
    }

    @Override
    public List<Game> findNLostAway(String clubName, Integer number) {
        List<Game> games = gameRepository.findNLostAway(clubName, number);

        if(games.size() == 0) return null;
        else return games;
    }

    @Override
    public List<Game> findDrawnAway(String clubName, Pageable pageable) {
        List<Game> games = gameRepository.findDrawnAway(clubName, pageable);

        if(games.size() == 0) return null;
        else return games;
    }

    @Override
    public List<Game> findNNumbersOfDrawnAway(String clubName, Integer number) {
        List<Game> games = gameRepository.findNNumbersOfDrawnAway(clubName, number);

        if(games.size() == 0) return null;
        else return games;
    }

    @Override
    public List<Game> findWinAway(String clubName, Pageable pageable) {
        List<Game> games = gameRepository.findWinAway(clubName, pageable);

        if(games.size() == 0) return null;
        else return games;
    }

    @Override
    public List<Game> findNNumbersOfWinsAway(String clubName, Integer number) {
        List<Game> games = gameRepository.findNNumbersOfWinsAway(clubName, number);

        if(games.size() == 0) return null;
        else return games;
    }


}
