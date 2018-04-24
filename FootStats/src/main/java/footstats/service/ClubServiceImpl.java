package footstats.service;

import footstats.model.Club;
import footstats.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository clubRepository;


    @Override
    @Transactional
    public void save(Club club) {

        clubRepository.save(club);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {

        clubRepository.delete(id);
    }

    @Override
    public Iterable<Club> findAll() {

        Iterable<Club> clubs = clubRepository.findAll();
        if(clubs != null) {
            return clubs;
        } else {
            return null;
        }
    }

    @Override
    public Club findById(Integer id) {

        Club c = clubRepository.findOne(id);

        if(c != null) {
            return c;
        } else {
            return null;
        }
    }

    @Override
    public Club findByName(String clubName) {
        return clubRepository.findByName(clubName);
    }
}
