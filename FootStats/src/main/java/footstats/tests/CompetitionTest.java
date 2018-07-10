package footstats.tests;

import footstats.model.Competition;
import footstats.model.Country;
import footstats.repository.CompetitionRepository;
import footstats.service.CompetitionService;
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
public class CompetitionTest {
    @Autowired
    private CompetitionService competitionService;

    @MockBean
    private CompetitionRepository competitionRepository;

    @Test
    public void findAllTest() throws Exception {

        Competition competition1 = new Competition();
        Competition competition2 = new Competition();

        competition1.setId(1);
        competition2.setId(2);

        competition1.setName("Champion's League");
        competition2.setName("World Cup");

        competition1.setRank(1);
        competition2.setRank(2);

        Country country1 = new Country();
        Country country2 = new Country();
        country1.setName("International");
        country2.setName("Some Country");

        competition1.setCountry(country1);
        competition2.setCountry(country2);

        List<Competition> competitionList = new ArrayList<>();
        competitionList.add(competition1);
        competitionList.add(competition2);

        Mockito.when(competitionRepository.findAll()).thenReturn(competitionList);
        assertThat(competitionService.findAll()).isEqualTo(competitionList);
    }

    @Test
    public void findByIdTest() throws Exception {

        Competition competition1 = new Competition();
        competition1.setId(1);
        competition1.setName("Champion's League");
        competition1.setRank(1);

        Country country1 = new Country();
        country1.setName("International");

        competition1.setCountry(country1);

        Mockito.when(competitionRepository.findOne(1)).thenReturn(competition1);
        assertThat(competitionService.findById(1)).isEqualTo(competition1);
    }

    @Test
    public void findByNameTest() throws Exception{

        Competition competition1 = new Competition();
        competition1.setId(1);
        competition1.setName("Champion's League");
        competition1.setRank(1);

        Country country1 = new Country();
        country1.setName("International");

        competition1.setCountry(country1);

        Mockito.when(competitionRepository.findOne(1)).thenReturn(competition1);
        assertThat(competitionService.findByName(competition1.getName())).isEqualTo(competition1);
    }

    @Test
    public void deleteById() throws Exception{

        Competition competition1 = new Competition();
        competition1.setId(1);
        competition1.setName("Champion's League");
        competition1.setRank(1);

        Country country1 = new Country();
        country1.setName("International");

        competition1.setCountry(country1);

        Mockito.when(competitionRepository.findOne(1)).thenReturn(competition1);
        Mockito.when(competitionRepository.exists(competition1.getId())).thenReturn(false);
        assertFalse(competitionRepository.exists(competition1.getId()));

    }
}
