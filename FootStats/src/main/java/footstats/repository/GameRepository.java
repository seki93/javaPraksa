package footstats.repository;

import footstats.model.Club;
import footstats.model.Game;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {

    void deleteById(Integer id);

    @Query("SELECT g FROM Game g WHERE g.awayClub.name = ?1 OR g.homeClub.name = ?1")
    List<Game> findAllMatch(String clubName);

    @Query(value = "SELECT g FROM Game g WHERE g.homeClub.name = ?1 AND g.matchStats.goals_homeclub > g.matchStats.goals_awayclub")
    List<Game> findWinHome(String clubName, Pageable pageable);

    default List<Game> findNNumbersOfWinAtHome(String clubName,Integer number) {
        return findWinHome(clubName, new PageRequest(0,number));
    }

    @Query(value = "SELECT g FROM Game g WHERE g.homeClub.name = ?1 AND g.matchStats.goals_homeclub = g.matchStats.goals_awayclub")
    List<Game> findDrawnAtHome(String clubName, Pageable pageable);

    default List<Game> findNNumbersOfDrawnAtHome(String clubName, Integer number){
        return  findDrawnAtHome(clubName, new PageRequest(0, number));
    }

    @Query(value = "SELECT g FROM Game g WHERE g.homeClub.name = ?1 AND g.matchStats.goals_homeclub < g.matchStats.goals_awayclub")
    List<Game> findLostAtHome(String clubName, Pageable pageable);

    default List<Game> findNLostAtHome(String clubName, Integer number){
        return findLostAtHome(clubName, new PageRequest(0, number));
    }

    @Query(value = "SELECT g FROM Game g WHERE g.homeClub.name = ?1 AND " +
            "g.matchStats.half_time_goals_homeclub > g.matchStats.half_time_goals_awayclub")
    List<Game> findWinHomeOnHalfTime(String clubName);

    @Query(value = "SELECT g FROM Game g WHERE g.homeClub.name = ?1 AND " +
            "matchStats.half_time_goals_homeclub < g.matchStats.half_time_goals_awayclub")
    List<Game> findLostHomeOnHalfTime(String clubName);

    @Query(value = "SELECT g FROM Game g WHERE g.homeClub.name = ?1 AND " +
            "matchStats.half_time_goals_homeclub = g.matchStats.half_time_goals_awayclub")
    List<Game> findDrawHomeOnHalfTime(String clubName);

    @Query(value = "SELECT AVG(g.matchStats.yellow_cards_hometeam) FROM Game g WHERE g.homeClub.name = ?1")
    List<Game> findAverageOfYellowCardsAtHome(String clubName);

    @Query(value = "SELECT AVG(g.matchStats.red_cards_hometeam) FROM Game g WHERE g.homeClub.name = ?1")
    List<Game> findAverageOfRedCardsAtHome(String clubName);

    //AWAY

    @Query(value = "SELECT g FROM Game g WHERE g.awayClub.name = ?1 AND g.matchStats.goals_homeclub > g.matchStats.goals_awayclub")
    List<Game> findAllLostAway(String clubName, Pageable pageable);

    default List<Game> findNLostAway(String clubName, Integer number){
        return findAllLostAway(clubName, new PageRequest(0, number));
    }

    @Query(value = "SELECT g FROM Game g WHERE g.awayClub.name = ?1 AND g.matchStats.goals_homeclub = g.matchStats.goals_awayclub")
    List<Game> findDrawnAway(String clubName, Pageable pageable);

    default List<Game> findNNumbersOfDrawnAway(String clubName, Integer number){
        return  findDrawnAway(clubName, new PageRequest(0, number));
    }

    @Query(value = "SELECT g FROM Game g WHERE g.awayClub.name = ?1 AND g.matchStats.goals_homeclub < g.matchStats.goals_awayclub")
    List<Game> findWinAway(String clubName, Pageable pageable);

    default List<Game> findNNumbersOfWinsAway(String clubName,Integer number) {
        return findWinAway(clubName, new PageRequest(0,number));
    }

    @Query(value = "SELECT g FROM Game g WHERE g.awayClub.name = ?1 AND " +
            "g.matchStats.half_time_goals_homeclub > g.matchStats.half_time_goals_awayclub")
    List<Game> findWinAwayOnHalfTime(String clubName);

    @Query(value = "SELECT g FROM Game g WHERE g.awayClub.name = ?1 AND " +
            "matchStats.half_time_goals_homeclub < g.matchStats.half_time_goals_awayclub")
    List<Game> findLostAwayOnHalfTime(String clubName);

    @Query(value = "SELECT g FROM Game g WHERE g.awayClub.name = ?1 AND " +
            "matchStats.half_time_goals_homeclub = g.matchStats.half_time_goals_awayclub")
    List<Game> findDrawAwayOnHalfTime(String clubName);

    @Query(value = "SELECT AVG(g.matchStats.yellow_cards_awayteam) FROM Game g WHERE g.awayClub.name = ?1")
    List<Game> findAverageOfYellowCardsAway(String clubName);

    @Query(value = "SELECT AVG(g.matchStats.red_cards_awayteam) FROM Game g WHERE g.awayClub.name = ?1")
    List<Game> findAverageOfRedCardsAway(String clubName);

    @Query(value = "SELECT g FROM Game g WHERE g.homeClub.name = ?1 AND g.awayClub.name = ?2 OR g.homeClub.name = ?2 AND g.awayClub.name = ?1")
    List<Game> findH2HwinAtHome(String homeClub,String awayClub, Pageable pageable);

    default List<Game> findH2HnNumbersOfWinAtHome(String homeClub,String awayClub, Integer number) {
        return findH2HwinAtHome(homeClub,awayClub, new PageRequest(0,number));
    }


}
