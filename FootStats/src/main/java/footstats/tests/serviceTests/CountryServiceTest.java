package footstats.tests.serviceTests;

import footstats.model.Country;
import footstats.repository.CountryRepository;
import footstats.service.CountryService;
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
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @MockBean
    private CountryRepository countryRepository;

    @Test
    public void findAll() {

        Country country = new Country();
        country.setId(1);
        country.setName("Serbia");
        country.setCountryCode("SRB");

        Country country1 = new Country();
        country1.setId(2);
        country1.setName("England");
        country1.setCountryCode("ENG");

        List<Country> countryList = new ArrayList<>();
        countryList.add(country);
        countryList.add(country1);

        Mockito.when(countryRepository.findAll()).thenReturn(countryList);
        assertThat(countryService.findAll()).isEqualTo(countryList);
    }

    @Test
    public void findById() {

        Country country = new Country();
        country.setId(1);
        country.setName("Serbia");
        country.setCountryCode("SRB");

        Mockito.when(countryRepository.findOne(1)).thenReturn(country);
        assertThat(countryService.findById(1)).isEqualTo(country);
    }

    @Test
    public void findByName() {

        Country country = new Country();
        country.setId(1);
        country.setName("Serbia");
        country.setCountryCode("SRB");

        Mockito.when(countryRepository.findByName("Serbia")).thenReturn(country);
        assertThat(countryService.findByName("Serbia")).isEqualTo(country);
    }
}