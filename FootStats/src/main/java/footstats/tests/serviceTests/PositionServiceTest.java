package footstats.tests.serviceTests;

import footstats.model.Position;
import footstats.repository.PositionRepository;
import footstats.service.PositionService;
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
public class PositionServiceTest {

    @Autowired
    private PositionService positionService;

    @MockBean
    private PositionRepository positionRepository;

    @Test
    public void findAll() {

        Position position = new Position();
        position.setId(1);
        position.setName("Forward");

        Position position1 = new Position();
        position1.setId(2);
        position1.setName("Defender");

        List<Position> positionList = new ArrayList<>();
        positionList.add(position);
        positionList.add(position1);

        Mockito.when(positionRepository.findAll()).thenReturn(positionList);
        assertThat(positionService.findAll()).isEqualTo(positionList);
    }

    @Test
    public void findById() {

        Position position = new Position();
        position.setId(1);
        position.setName("Forward");

        Mockito.when(positionRepository.findOne(1)).thenReturn(position);
        assertThat(positionService.findById(1)).isEqualTo(position);
    }

    @Test
    public void findByName() {

        Position position = new Position();
        position.setId(1);
        position.setName("Forward");

        Mockito.when(positionRepository.findByName("Forward")).thenReturn(position);
        assertThat(positionService.findByName("Forward")).isEqualTo(position);
    }
}