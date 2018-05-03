package footstats.service;

import footstats.model.Stadium;

import java.util.List;

public interface StadiumService {

    Iterable<Stadium> findAll();

    Stadium findById(Integer id);

    void deleteById(Integer id);

    void save(Stadium s);

    Stadium findByName(String stadiumName);

    List<Stadium> findStadiumsByName(String name);
}
