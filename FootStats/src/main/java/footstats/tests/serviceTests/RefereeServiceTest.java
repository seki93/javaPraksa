package footstats.tests.serviceTests;

import footstats.model.Referee;
import footstats.repository.RefereeRepository;
import footstats.service.RefereeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RefereeServiceTest {

    @Autowired
    private RefereeService refereeService;

    @MockBean
    private RefereeRepository refereeRepository;

    @Test
    public void findAll() {

        Referee referee = new Referee();
        referee.setId(1);
        referee.setFirstName("Petar");
        referee.setLastName("Petrovic");
        referee.setDateOfBirth(new Date());

        Referee referee1 = new Referee();
        referee1.setId(2);
        referee1.setFirstName("Sima");
        referee1.setLastName("Simic");
        referee1.setDateOfBirth(new Date());

        List<Referee> refereeList = new ArrayList<>();
        refereeList.add(referee);
        refereeList.add(referee1);

        Mockito.when(refereeRepository.findAll()).thenReturn(refereeList);
        assertThat(refereeService.findAll()).isEqualTo(refereeList);
    }

    @Test
    public void findById() {

        Referee referee = new Referee();
        referee.setId(1);
        referee.setFirstName("Petar");
        referee.setLastName("Petrovic");
        referee.setDateOfBirth(new Date());

        Mockito.when(refereeRepository.findOne(1)).thenReturn(referee);
        assertThat(refereeService.findById(1)).isEqualTo(referee);
    }
}