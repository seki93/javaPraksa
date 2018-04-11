package footstats.service;

import footstats.model.Person;
import footstats.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonSeviceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    @Transactional
    public void save(Person person) {

        personRepository.save(person);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {

        personRepository.delete(id);

    }

    @Override
    public Iterable<Person> findAll() {

        return personRepository.findAll();
    }

    @Override
    public Person findById(Integer id) {

        Person p = personRepository.findOne(id);

        if(p != null) {
            return p;
        } else {
            return null;
        }
    }
}
