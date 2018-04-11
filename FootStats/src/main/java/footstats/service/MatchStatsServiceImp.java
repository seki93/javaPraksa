package footstats.service;

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
    }

    @Override
    @Transactional
    public void save(MatchStats matchStats) {


    }

    @Override
    public Iterable<MatchStats> findAll() {

        return null;
    }

    @Override
    public MatchStats findById(Integer id) {

        return null;
    }
}
