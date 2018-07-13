package footstats.tests.serviceTests;

import footstats.model.Club;
import footstats.model.NationalTeam;
import footstats.model.Player;
import footstats.repository.PlayerRepository;
import footstats.service.PlayerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerServiceTest {

    @Autowired
    private PlayerService playerService;

    @MockBean
    private PlayerRepository playerRepository;

    @Test
    public void findAllTest() throws Exception{
        Player player1 = new Player();
        player1.setId(1);
        Club club1 = new Club();
        club1.setName("Juventus");
        player1.setClub(club1);

        NationalTeam nationalTeam1 = new NationalTeam();
        nationalTeam1.setName("Serbia");
        player1.setNationalTeam(nationalTeam1);

        Player player2 = new Player();
        player2.setId(2);
        Club club2 = new Club();
        club2.setName("Real Madrid");
        player2.setClub(club2);

        NationalTeam nationalTeam2 = new NationalTeam();
        nationalTeam2.setName("Croatia");
        player2.setNationalTeam(nationalTeam2);

        List<Player> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        Mockito.when(playerRepository.findAll()).thenReturn(playerList);
        assertThat(playerService.findAll()).isEqualTo(playerList);
    }

    @Test
    public void findById() throws Exception{
        Player player1 = new Player();
        player1.setId(1);
        Club club1 = new Club();
        club1.setName("Juventus");
        player1.setClub(club1);

        NationalTeam nationalTeam1 = new NationalTeam();
        nationalTeam1.setName("Serbia");
        player1.setNationalTeam(nationalTeam1);

        Mockito.when(playerRepository.findOne(1)).thenReturn(player1);
        assertThat(playerService.findById(player1.getId())).isEqualTo(player1);
    }
}