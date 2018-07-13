package footstats.tests.serviceTests;

import footstats.model.Club;
import footstats.model.Game;
import footstats.model.MatchStats;
import footstats.model.Referee;
import footstats.repository.GameRepository;
import footstats.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameServiceTest {

    @Autowired
    private GameService gameService;

    @MockBean
    private GameRepository gameRepository;

    @Test
    public void findAllTest() throws Exception{

        Game game1 = new Game();
        game1.setId(1);

        Club club1 = new Club();
        Club club2 = new Club();

        game1.setAwayClub(club1);
        game1.setHomeClub(club2);

        Referee referee = new Referee();
        game1.setReferee(referee);

        Game game2 = new Game();

        Club club3 = new Club();
        Club club4 = new Club();

        game2.setAwayClub(club3);
        game2.setHomeClub(club4);

        Referee referee1 = new Referee();
        game2.setReferee(referee1);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game1);
        gameList.add(game2);

        Mockito.when(gameRepository.findAll()).thenReturn(gameList);
        assertThat(gameService.findAll()).isEqualTo(gameList);
    }

    @Test
    public void findByIdTest() throws Exception {

        Game game1 = new Game();
        game1.setId(1);

        Club club1 = new Club();
        Club club2 = new Club();

        game1.setAwayClub(club1);
        game1.setHomeClub(club2);

        Referee referee = new Referee();
        game1.setReferee(referee);

        Mockito.when(gameRepository.findOne(1)).thenReturn(game1);
        assertThat(gameService.findById(1)).isEqualTo(game1);
    }

    @Test
    public void findAllMatchTest() throws Exception{
        //Game 1
        Game game1 = new Game();
        game1.setId(1);
        Club club1 = new Club();
        club1.setName("Arsenal");
        Club club2 = new Club();
        club2.setName("Juventus");

        game1.setAwayClub(club1);
        game1.setHomeClub(club2);
        //Game2
        Game game2 = new Game();
        game2.setId(2);

        Club club3 = new Club();
        club3.setName("Arsenal");
        Club club4 = new Club();
        club4.setName("Real Madrid");

        game2.setAwayClub(club3);
        game2.setHomeClub(club4);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game1);
        gameList.add(game2);

        Mockito.when(gameRepository.findAllMatch("Arsenal")).thenReturn(gameList);
        assertThat(gameService.findAllMatch(game1.getAwayClub().getName())).isEqualTo(gameList);
    }

    @Test
    public void findWinAwayTest() throws Exception{
        //Game 1
        Game game1 = new Game();
        game1.setId(1);
        Club club1 = new Club();
        club1.setName("Arsenal");
        Club club2 = new Club();
        club2.setName("Juventus");

        game1.setAwayClub(club1);
        game1.setHomeClub(club2);
        MatchStats matchStats1 = new MatchStats();
        matchStats1.setGoals_awayclub(3);
        matchStats1.setGoals_homeclub(1);
        game1.setMatchStats(matchStats1);
        //Game2
        Game game2 = new Game();
        game2.setId(2);

        Club club3 = new Club();
        club3.setName("Arsenal");
        Club club4 = new Club();
        club4.setName("Real Madrid");

        game2.setAwayClub(club3);
        game2.setHomeClub(club4);

        MatchStats matchStats2 = new MatchStats();
        matchStats2.setGoals_awayclub(2);
        matchStats2.setGoals_homeclub(1);
        game2.setMatchStats(matchStats2);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game1);
        gameList.add(game2);

        Pageable pageable = null;

        Mockito.when(gameRepository.findWinAway(game1.getAwayClub().getName(), pageable)).thenReturn(gameList);
        assertThat(gameService.findWinAway("Arsenal", pageable)).isEqualTo(gameList);
    }

    @Test
    public void findWinHomeTest() throws Exception{
        //Game 1
        Game game1 = new Game();
        game1.setId(1);
        Club club1 = new Club();
        club1.setName("Arsenal");
        Club club2 = new Club();
        club2.setName("Juventus");

        game1.setAwayClub(club1);
        game1.setHomeClub(club2);
        MatchStats matchStats1 = new MatchStats();
        matchStats1.setGoals_awayclub(1);
        matchStats1.setGoals_homeclub(3);
        game1.setMatchStats(matchStats1);
        //Game2
        Game game2 = new Game();
        game2.setId(2);

        Club club3 = new Club();
        club3.setName("Real Madrid");
        Club club4 = new Club();
        club4.setName("Juventus");

        game2.setAwayClub(club3);
        game2.setHomeClub(club4);

        MatchStats matchStats2 = new MatchStats();
        matchStats2.setGoals_awayclub(1);
        matchStats2.setGoals_homeclub(2);
        game2.setMatchStats(matchStats2);

        List<Game> gameList = new ArrayList<>();
        gameList.add(game1);
        gameList.add(game2);

        Pageable pageable = null;

        Mockito.when(gameRepository.findWinHome(game1.getHomeClub().getName(), pageable)).thenReturn(gameList);
        assertThat(gameService.findWinHome("Juventus", pageable)).isEqualTo(gameList);
    }
}
