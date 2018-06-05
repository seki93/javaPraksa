package footstats.service;

import footstats.model.Club;
import footstats.model.Game;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GameService {
    public void deleteById(Integer id);
    public void save (Game game);
    public Iterable<Game> findAll();
    public Game findById(Integer id);
    List<Game> findAllMatch(String clubName);
    List<Game> findWinHome(String clubName, Pageable pageable);
    List<Game> findNNumbersOfWinAtHome(String clubName, Integer number);

    List<Game> findDrawnAtHome(String clubName, Pageable pageable);
    List<Game> findNNumbersOfDrawnAtHome(String clubName, Integer number);

    List<Game> findLostAtHome(String clubName, Pageable pageable);
    List<Game> findNLostAtHome(String clubName, Integer number);

    List<Game> findWinHomeOnHalfTime(String clubName);
    List<Game> findLostHomeOnHalfTime(String clubName);
    List<Game> findDrawHomeOnHalfTime(String clubName);

    //AWAY

    List<Game> findAllLostAway(String clubName, Pageable pageable);
    List<Game> findNLostAway(String clubName, Integer number);

    List<Game> findDrawnAway(String clubName, Pageable pageable);
    List<Game> findNNumbersOfDrawnAway(String clubName, Integer number);

    List<Game> findWinAway(String clubName, Pageable pageable);
    List<Game> findNNumbersOfWinsAway(String clubName, Integer number);

    List<Game> findWinAwayOnHalfTime(String clubName);
    List<Game> findLostAwayOnHalfTime(String clubName);
    List<Game> findDrawAwayOnHalfTime(String clubName);

}
