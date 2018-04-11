package footstats.service;

import footstats.model.Match;
import footstats.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MatchServiceImp implements MatchService {

    @Autowired
    MatchRepository matchRepository;

    @Override
    @Transactional
    public void deleteById(Integer id) {
        matchRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(Match match) {
        matchRepository.save(match);
    }

    @Override
    public Iterable<Match> findAll() {

       Iterable<Match> m = matchRepository.findAll();

       if ( m != null){
           return m;
       } else {
           return null;
       }
    }

    @Override
    public Match findById(Integer id) {
        Match m = matchRepository.findOne(id);

        if(m != null){
            return m;
        } else {
            return null;
        }
    }
}
