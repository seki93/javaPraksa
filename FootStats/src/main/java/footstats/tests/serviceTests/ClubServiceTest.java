package footstats.tests.serviceTests;

import footstats.model.City;
import footstats.model.Club;
import footstats.repository.ClubRepository;
import footstats.service.ClubService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
public class ClubServiceTest {

    @Autowired
    private ClubService clubService;

    @MockBean
    private ClubRepository clubRepository;

    @Test
    public void findAllTest() throws Exception {
        Club club1 = new Club();
        club1.setId(1);
        club1.setName("Juventus");
        City city1 = new City();
        club1.setCity(city1);

        Club club2 = new Club();
        club2.setId(2);
        club2.setName("Arsenal");
        City city2 = new City();
        club2.setCity(city2);

        List<Club> clubList = new ArrayList<>();
        clubList.add(club1);
        clubList.add(club2);

        Mockito.when(clubRepository.findAll()).thenReturn(clubList);
        assertThat(clubService.findAll()).isEqualTo(clubList);
    }
    @Test
    public void findByIdTest() throws Exception{
        Club club1 = new Club();
        club1.setId(1);
        club1.setName("Juventus");
        City city1 = new City();
        club1.setCity(city1);

        Mockito.when(clubRepository.findOne(1)).thenReturn(club1);
        assertThat(clubService.findById(1)).isEqualTo(club1);
    }
    @Test
    public void findByNameTest() throws Exception{
        Club club1 = new Club();
        club1.setId(1);
        club1.setName("Juventus");
        City city1 = new City();
        club1.setCity(city1);
        Mockito.when(clubRepository.findByName(club1.getName())).thenReturn(club1);
        assertThat(clubService.findByName(club1.getName())).isEqualTo(club1);
    }

    @Test
    public void deleteByIdTest() throws Exception{
        Club club1 = new Club();
        club1.setId(1);
        club1.setName("Juventus");
        City city1 = new City();
        club1.setCity(city1);

        Mockito.when(clubRepository.findOne(1)).thenReturn(club1);
        Mockito.when(clubRepository.exists(club1.getId())).thenReturn(false);
        assertFalse(clubRepository.exists(club1.getId()));
    }
}

