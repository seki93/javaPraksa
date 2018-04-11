package footstats.service;

import footstats.model.Stadium;
import footstats.repository.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StadiumServiceImpl implements  StadiumService{

    @Autowired
    StadiumRepository stadiumRepository;

    @Override
    public Iterable<Stadium> findAll() {
        return null;
    }

    @Override
    public Stadium findById(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {

    }

    @Override
    @Transactional
    public void save(Stadium s) {

    }
}
