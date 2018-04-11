package footstats.service;

import footstats.model.Match;
import footstats.model.MatchStats;
import footstats.repository.MatchStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MatchStatsServiceImp implements MatchStatsService {

    @Autowired
    MatchStatsRepository matchStatsRepository;

    @Override
    @Transactional
    public void deleteById(Integer id) {
        matchStatsRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(MatchStats matchStats) {

        matchStatsRepository.save(matchStats);

    }

    @Override
    public Iterable<MatchStats> findAll() {

        return matchStatsRepository.findAll();
    }

    @Override
    public MatchStats findById(Integer id) {

        MatchStats ms = matchStatsRepository.findOne(id);
        if (ms != null){
            return ms;
        } else {
            return null;
        }
    }
}
