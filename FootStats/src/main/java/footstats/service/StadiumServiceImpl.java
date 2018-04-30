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
        Iterable<Stadium> stadiums = stadiumRepository.findAll();

        if(stadiums != null) return  stadiums;
        else  return null;
    }

    @Override
    public Stadium findById(Integer id) {

        Stadium s = stadiumRepository.findOne(id);

        if(s != null) return s;
        else return null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        stadiumRepository.delete(id);

    }

    @Override
    @Transactional
    public void save(Stadium s) {
        stadiumRepository.save(s);
    }

    @Override
    public Stadium findByName(String stadiumName) {
        return stadiumRepository.findByName(stadiumName);
    }

    @Override
    public Iterable<Stadium> findStadiumsByName(String name) {
        Iterable<Stadium> s = stadiumRepository.findStadiumsByName(name);
        if(s != null) return s;

        return null;
    }


}
