package footstats.service;

import footstats.model.NationalTeam;
import footstats.repository.NationalTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class NationalTeamServiceImp implements NationalTeamService  {

    @Autowired
    NationalTeamRepository nationalTeamRepository;

    @Override
    @Transactional
    public void deleteById(Integer id) {
        nationalTeamRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(NationalTeam nationalTeam) {
        nationalTeamRepository.save(nationalTeam);
    }

    @Override
    public Iterable<NationalTeam> findAll() {

        Iterable<NationalTeam> nteam = nationalTeamRepository.findAll();

        if( nteam != null){
            return nteam;
        } else {
            return null;
        }
    }

    @Override
    public NationalTeam findById(Integer id) {
        NationalTeam n = nationalTeamRepository.findOne(id);

        if( n != null){
            return n;
        } else {
            return null;
        }
    }
}
