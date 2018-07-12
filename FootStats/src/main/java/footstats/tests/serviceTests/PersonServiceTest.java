package footstats.tests.serviceTests;

import footstats.model.Country;
import footstats.model.Person;
import footstats.repository.PersonRepository;
import footstats.service.PersonService;
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
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @MockBean
    private PersonRepository personRepository;

    @Test
    public void findAll() {

        Person person = new Person();
        person.setId(1);
        person.setFirstName("Vladimir");
        person.setLastName("Jevtic");
        person.setDateOfBirth(new Date());
        Country country = new Country();
        country.setId(1);
        country.setName("Serbia");
        country.setCountryCode("SRB");
        person.setCountryOfBirth(country);

        Person person1 = new Person();
        person1.setId(2);
        person1.setFirstName("Stefan");
        person1.setLastName("Sekeres");
        person1.setDateOfBirth(new Date());
        Country country1 = new Country();
        country1.setId(2);
        country1.setName("Serbia");
        country1.setCountryCode("SRB");
        person1.setCountryOfBirth(country1);

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person1);

        Mockito.when(personRepository.findAll()).thenReturn(personList);
        assertThat(personService.findAll()).isEqualTo(personList);
    }

    @Test
    public void findById() {

        Person person = new Person();
        person.setId(1);
        person.setFirstName("Vladimir");
        person.setLastName("Jevtic");
        person.setDateOfBirth(new Date());
        Country country = new Country();
        country.setId(1);
        country.setName("Serbia");
        country.setCountryCode("SRB");
        person.setCountryOfBirth(country);

        Mockito.when(personRepository.findOne(1)).thenReturn(person);
        assertThat(personService.findById(1)).isEqualTo(person);
    }
}