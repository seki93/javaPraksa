package footstats.service;

import footstats.model.ClubHistory;

public interface ClubHistoryService {

    public void save(ClubHistory clubHistory);

    public void deleteById(Integer id);

    public Iterable<ClubHistory> findAll();

    public ClubHistory findByid(Integer  id);
}
