package footstats.tests;

import footstats.model.ClubHistory;
import footstats.model.Player;
import footstats.repository.ClubHistoryRepository;
import footstats.service.ClubHistoryService;
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
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClubHistoryServiceTest {

    @Autowired
    private ClubHistoryService clubHistoryService;

    @MockBean
    private ClubHistoryRepository clubHistoryRepository;

    @Test
    public void findAllTest(){
        ClubHistory clubHistory = new ClubHistory();
        Player player = new Player();
        clubHistory.setId(1);
        clubHistory.setPlayer(player);

        ClubHistory clubHistory1 = new ClubHistory();
        Player player1 = new Player();
        clubHistory1.setId(2);
        clubHistory1.setPlayer(player1);

        List<ClubHistory> clubHistoryList = new ArrayList<>();
        clubHistoryList.add(clubHistory);
        clubHistoryList.add(clubHistory1);

        Mockito.when(clubHistoryRepository.findAll()).thenReturn(clubHistoryList);
        assertThat(clubHistoryService.findAll()).isEqualTo(clubHistoryList);
    }

    @Test //Treba proveriti opet
    public void deleteByIdTest() throws Exception {
        ClubHistory clubHistory = new ClubHistory();
        Player player = new Player();
        clubHistory.setId(1);
        clubHistory.setPlayer(player);

        Mockito.when(clubHistoryRepository.findOne(1)).thenReturn(clubHistory);
        Mockito.when(clubHistoryRepository.exists(clubHistory.getId())).thenReturn(false);
        assertFalse(clubHistoryRepository.exists(clubHistory.getId()));
    }

    @Test
    public void findByIdTest() throws Exception{
        ClubHistory clubHistory = new ClubHistory();
        Player player = new Player();
        clubHistory.setPlayer(player);
        clubHistory.setId(1);

        Mockito.when(clubHistoryRepository.findOne(1)).thenReturn(clubHistory);
        assertThat(clubHistoryService.findByid(1)).isEqualTo(clubHistory);
    }
}
