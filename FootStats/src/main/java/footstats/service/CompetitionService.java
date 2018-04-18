package footstats.service;

import footstats.model.Competition;

public interface CompetitionService {

    public void deleteById(Integer id);
    public void save (Competition competition);
    public Iterable<Competition> findAll();
    public Competition findById(Integer id);

    public Integer findIdByName(String competitionName);
}
