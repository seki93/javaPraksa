package footstats.service;

import footstats.model.Referee;

public interface RefereeService {

    public Iterable<Referee> findAll();

    public Referee findById(Integer id);

    public void deleteById(Integer id);

    public void save(Referee r);

    public Integer findIdByName(String refereeFirstName, String refereeLastName);
}
