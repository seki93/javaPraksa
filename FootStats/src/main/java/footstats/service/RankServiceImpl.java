package footstats.service;

import footstats.model.Rank;
import footstats.repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RankServiceImpl implements RankService {

    @Autowired
    RankRepository rankRepository;

    @Override
    public Iterable<Rank> findAll() {
        return null;
    }

    @Override
    public Rank findById(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {

    }

    @Override
    @Transactional
    public void save(Rank r) {

    }
}
