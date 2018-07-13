package footstats.tests.serviceTests;

import footstats.model.Country;
import footstats.model.NationalTeam;
import footstats.repository.NationalTeamRepository;
import footstats.service.NationalTeamService;
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


@RunWith(SpringRunner.class)
@SpringBootTest
public class NationalTeamServiceTest {

    @Autowired
    private NationalTeamService nationalTeamService;

    @MockBean
    private NationalTeamRepository nationalTeamRepository;

    @Test
    public void findAllTest() throws Exception{
        NationalTeam nationalTeam1 = new NationalTeam();
        NationalTeam nationalTeam2 = new NationalTeam();

        nationalTeam1.setName("Serbia");
        nationalTeam2.setName("Russia");

        Country country1 = new Country();
        Country country2 = new Country();
        country1.setName("Serbia");
        country2.setName("Russia");
        nationalTeam1.setCountry(country1);
        nationalTeam2.setCountry(country2);

        List<NationalTeam> nationalTeamList = new ArrayList<>();
        nationalTeamList.add(nationalTeam1);
        nationalTeamList.add(nationalTeam2);

        Mockito.when(nationalTeamRepository.findAll()).thenReturn(nationalTeamList);
        assertThat(nationalTeamService.findAll()).isEqualTo(nationalTeamList);
    }

    @Test
    public void findByIdTest() throws Exception{

        NationalTeam nationalTeam = new NationalTeam();
        nationalTeam.setId(1);
        nationalTeam.setName("Serbia");
        Country country1 = new Country();
        country1.setName("Serbia");
        nationalTeam.setCountry(country1);

        Mockito.when(nationalTeamRepository.findOne(1)).thenReturn(nationalTeam);
        assertThat(nationalTeamService.findById(nationalTeam.getId())).isEqualTo(nationalTeam);
    }
    @Test
    public void findByNameTest() throws Exception{

        NationalTeam nationalTeam = new NationalTeam();
        nationalTeam.setId(1);
        nationalTeam.setName("Serbia");
        Country country1 = new Country();
        country1.setName("Serbia");
        nationalTeam.setCountry(country1);

        Mockito.when(nationalTeamRepository.findByName(nationalTeam.getName())).thenReturn(nationalTeam);
        assertThat(nationalTeamService.findByName("Serbia")).isEqualTo(nationalTeam);
    }

    @Test
    public void findNationalTeamByName() throws Exception{
        NationalTeam nationalTeam1 = new NationalTeam();
        nationalTeam1.setId(1);
        nationalTeam1.setName("Serbia");
        Country country1 = new Country();
        country1.setName("Serbia");
        nationalTeam1.setCountry(country1);

        NationalTeam nationalTeam2 = new NationalTeam();
        nationalTeam2.setId(2);
        nationalTeam2.setName("Russia");
        Country country2 = new Country();
        country2.setName("Russia");
        nationalTeam2.setCountry(country2);
        List<NationalTeam> nationalTeamList = new ArrayList<>();
        nationalTeamList.add(nationalTeam1);
        nationalTeamList.add(nationalTeam2);
        Mockito.when(nationalTeamRepository.findNationalTeamByName(nationalTeam1.getName())).thenReturn(nationalTeamList);
        assertThat(nationalTeamService.findNationalTeamByName("Serbia")).isEqualTo(nationalTeamList);
    }
}
