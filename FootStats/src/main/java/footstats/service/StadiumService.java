package footstats.service;

import footstats.model.Stadium;

public interface StadiumService {

    public Iterable<Stadium> findAll();

    public Stadium findById(Integer id);

    public void deleteById(Integer id);

    public void save(Stadium s);
}
