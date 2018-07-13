package footstats.tests.serviceTests;


import footstats.model.MatchStats;
import footstats.repository.MatchStatsRepository;
import footstats.service.MatchStatsService;
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
public class MatchStatsServiceTest {

    @Autowired
    private MatchStatsService matchStatsService;

    @MockBean
    private MatchStatsRepository matchStatsRepository;

    @Test
    public void findAllTest() throws Exception{
        MatchStats matchStats1 = new MatchStats();
        MatchStats matchStats2 = new MatchStats();

        matchStats1.setId(1);
        matchStats2.setId(2);

        matchStats1.setGoals_homeclub(1);
        matchStats1.setGoals_awayclub(2);

        matchStats2.setGoals_awayclub(2);
        matchStats2.setGoals_homeclub(3);

        List<MatchStats> matchStatsList = new ArrayList<>();
        matchStatsList.add(matchStats1);
        matchStatsList.add(matchStats2);

        Mockito.when(matchStatsRepository.findAll()).thenReturn(matchStatsList);
        assertThat(matchStatsService.findAll()).isEqualTo(matchStatsList);
    }

    @Test
    public void findByIdTest() throws Exception {
        MatchStats matchStats1 = new MatchStats();
        matchStats1.setId(1);

        matchStats1.setGoals_homeclub(1);
        matchStats1.setGoals_awayclub(2);

        Mockito.when(matchStatsRepository.findOne(1)).thenReturn(matchStats1);
        assertThat(matchStatsService.findById(matchStats1.getId())).isEqualTo(matchStats1);
    }
}

