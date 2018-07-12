package footstats.tests.serviceTests;

import footstats.model.Stadium;
import footstats.repository.StadiumRepository;
import footstats.service.StadiumService;
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
public class StadiumServiceTest {

    @Autowired
    private StadiumService stadiumService;

    @MockBean
    private StadiumRepository stadiumRepository;

    @Test
    public void findAll() {

        Stadium stadium = new Stadium();
        stadium.setId(1);
        stadium.setName("Old Traford");

        Stadium stadium1 = new Stadium();
        stadium1.setId(2);
        stadium1.setName("Emirates");

        List<Stadium> stadiumList = new ArrayList<>();
        stadiumList.add(stadium);
        stadiumList.add(stadium1);

        Mockito.when(stadiumRepository.findAll()).thenReturn(stadiumList);
        assertThat(stadiumRepository.findAll()).isEqualTo(stadiumList);
    }

    @Test
    public void findById() {

        Stadium stadium = new Stadium();
        stadium.setId(1);
        stadium.setName("Old Traford");

        Mockito.when(stadiumRepository.findOne(1)).thenReturn(stadium);
        assertThat(stadiumService.findById(1)).isEqualTo(stadium);
    }

    @Test
    public void findByName() {

        Stadium stadium = new Stadium();
        stadium.setId(1);
        stadium.setName("Old Traford");

        Mockito.when(stadiumRepository.findByName("Old Traford")).thenReturn(stadium);
        assertThat(stadiumService.findByName("Old Traford")).isEqualTo(stadium);
    }
}