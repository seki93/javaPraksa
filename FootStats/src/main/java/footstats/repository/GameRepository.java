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




}
