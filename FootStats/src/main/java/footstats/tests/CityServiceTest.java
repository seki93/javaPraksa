package footstats.tests;

import footstats.model.City;
import footstats.model.Country;
import footstats.repository.CityRepository;
import footstats.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceTest {

    @Autowired
    private CityService cityService;

    @MockBean
    private CityRepository cityRepository;

    @Test
    public void findAll() {

        City city = new City();
        Country country = new Country();
        country.setId(1);
        country.setName("Serbia");
        country.setCountryCode("SRB");
        city.setId(1);
        city.setName("Belgrade");
        city.setCountry(country);

        City city1 = new City();
        Country country1 = new Country();
        country.setId(2);
        country.setName("England");
        country.setCountryCode("ENG");
        city.setId(2);
        city.setName("London");
        city.setCountry(country1);

        List<City> cityList = new ArrayList<>();
        cityList.add(city);
        cityList.add(city1);

        Mockito.when(cityRepository.findAll()).thenReturn(cityList);
        assertEquals(cityService.findAll(), cityList);

    }

    @Test
    public void findById() {

        City city = new City();
        Country country = new Country();
        country.setId(1);
        country.setName("Serbia");
        country.setCountryCode("SRB");
        city.setId(1);
        city.setName("Belgrade");
        city.setCountry(country);

        Mockito.when(cityRepository.findOne(1)).thenReturn(city);
        assertEquals(cityService.findById(1), city);
    }

    @Test
    public void findByName() {

        City city = new City();
        Country country = new Country();
        country.setId(1);
        country.setName("Serbia");
        country.setCountryCode("SRB");
        city.setId(1);
        city.setName("Belgrade");
        city.setCountry(country);

        Mockito.when(cityRepository.findByName("Belgrade")).thenReturn(city);
        assertEquals(cityService.findByName("Belgrade"), city);
    }
}