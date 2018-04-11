package footstats.service;

import footstats.model.Referee;
import footstats.repository.RefereeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RefereeServiceImpl implements RefereeService {

    @Autowired
    RefereeRepository refereeRepository;

    @Override
    public Iterable<Referee> findAll() {
        return null;
    }

    @Override
    public Referee findById(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {

    }

    @Override
    @Transactional
    public void save(Referee r) {

    }
}
