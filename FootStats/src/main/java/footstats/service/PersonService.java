package footstats.service;

import footstats.model.Person;

public interface PersonService {

    public void save(Person person);

    public void deleteById(Integer id);

    public Iterable<Person> findAll();

    public Person findById(Integer id);
}
