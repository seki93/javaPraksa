package footstats.service;

import footstats.model.Competition;
import footstats.repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CompetitionServiceImp implements CompetitionService {

    @Autowired
    CompetitionRepository competitionRepository;

    @Override
    @Transactional
    public void deleteById(Integer id) {
        competitionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(Competition competition) {

        competitionRepository.save(competition);
    }

    @Override
    public Iterable<Competition> findAll() {

       Iterable<Competition> c = competitionRepository.findAll();

       if(c != null){
           return c;
       } else {
           return null;
       }
    }

    @Override
    public Competition findById(Integer id) {
        Competition c = competitionRepository.findOne(id);

        if (c != null){
            return c;
        } else {
            return null;
        }
    }

    @Override
    public Integer findIdByName(String competitionName) {
        return competitionRepository.findIdByName(competitionName);
    }
}
