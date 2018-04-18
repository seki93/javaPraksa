package footstats.service;

import footstats.model.NationalTeam;

public interface NationalTeamService {
    public void deleteById(Integer id);
    public void save(NationalTeam nationalTeam);
    public Iterable<NationalTeam> findAll();
    public NationalTeam findById(Integer id);

    public Integer findIdByName(String nationalTeamName);
}
