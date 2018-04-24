package footstats.service;

import footstats.model.Club;

public interface ClubService {

    public void save(Club club);

    public void deleteById(Integer id);

    public Iterable<Club> findAll();

    public Club findById(Integer id);

    public Club findByName(String clubName);
}
