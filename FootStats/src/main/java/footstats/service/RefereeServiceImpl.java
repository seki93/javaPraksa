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
        Iterable<Referee> referees = refereeRepository.findAll();

        if( referees != null) return referees;
        else return null;
    }

    @Override
    public Referee findById(Integer id) {
        Referee r = refereeRepository.findOne(id);

        if(r != null) return r;
        else return null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        refereeRepository.delete(id);
    }

    @Override
    @Transactional
    public void save(Referee r) {
        refereeRepository.save(r);
    }

//    @Override
//    public Integer findIdByName(String refereeFirstName, String refereeLastName) {
//        return refereeRepository.findIdbyName(refereeFirstName, refereeLastName);
//    }
}
