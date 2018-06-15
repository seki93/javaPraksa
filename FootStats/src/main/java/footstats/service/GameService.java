package footstats.service;

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

    List<Game> findWinHomeOnHalfTime(String clubName, Pageable pageable);
    List<Game> findNWinAtHomeOnHalfTime(String clubName, Integer number);

    List<Game> findLostHomeOnHalfTime(String clubName, Pageable pageable);
    List<Game> findNLostAtHomeOnHalfTime(String clubName, Integer number);

    List<Game> findDrawHomeOnHalfTime(String clubName, Pageable pageable);
    List<Game> findNDrawAtHomeOnHalfTime(String clubName, Integer number);

    List<Game> findAverageOfYellowCardsAtHome(String clubName);
    List<Game> findAverageOfRedCardsAtHome(String clubName);

    List<Game> findAverageOfCornerKicksAtHome(String clubName);

    List<Game> findAverageOfTotalPassesAtHome(String clubName);

    List<Game> findAverageOfBallPossessionAtHome(String clubName);

    List<Game> findNumberOfFoulsByTeam(String clubName);

    List<Game> findNumberOfWinsAndNGoalsHomeTeam(String homeClub, Integer goals, Pageable pageable);
    List<Game> findNumberOfWinsAndGoalsHomeOfMatch(String homeClub, Integer goals, Integer number);

    //AWAY

    List<Game> findAllLostAway(String clubName, Pageable pageable);
    List<Game> findNLostAway(String clubName, Integer number);

    List<Game> findDrawnAway(String clubName, Pageable pageable);
    List<Game> findNNumbersOfDrawnAway(String clubName, Integer number);

    List<Game> findWinAway(String clubName, Pageable pageable);
    List<Game> findNNumbersOfWinsAway(String clubName, Integer number);

    List<Game> findWinAwayOnHalfTime(String clubName, Pageable pageable);
    List<Game> findNWinAwayOnHalfTime(String clubName, Integer number);

    List<Game> findLostAwayOnHalfTime(String clubName, Pageable pageable);
    List<Game> findNLostAwayOnHalfTime(String clubName, Integer number);

    List<Game> findDrawAwayOnHalfTime(String clubName, Pageable pageable);
    List<Game> findNDrawAwayOnHalfTime(String clubName, Integer number);

    List<Game> findAverageOfYellowCardsAway(String clubName);
    List<Game> findAverageOfRedCardsAway(String clubName);

    List<Game> findH2HallMatches(String homeClub, String awayClub, Pageable pageable);
    List<Game> findH2HnNumbersOfMatch(String homeClub, String awayClub, Integer number);

    List<Game> findAverageOfCornerKicksAway(String clubName);

    List<Game> findNgoals(Integer goals);

    List<Game> findAverageOfTotalPassesAway(String clubName);

    List<Game> findAverageOfBallPossessionAway(String clubName);

    List<Game> findNumberOfFoulsToTeam(String clubName);

    List<Game> findNumberOfWinsAndNGoalsAwayTeam(String awayClub, Integer goals, Pageable pageable);
    List<Game> findNumberOfWinsAndGoalsAwayOfMatch(String awayClub, Integer goals, Integer number);




}
