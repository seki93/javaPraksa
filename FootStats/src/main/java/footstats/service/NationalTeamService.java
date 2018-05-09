package footstats.service;

import footstats.model.NationalTeam;

import java.util.List;

public interface NationalTeamService {
    public void deleteById(Integer id);
    public void save(NationalTeam nationalTeam);
    public Iterable<NationalTeam> findAll();
    public NationalTeam findById(Integer id);

    public NationalTeam findByName(String nationalTeamName);

    public List<NationalTeam> findByNames(String nationalTeamName);
}
