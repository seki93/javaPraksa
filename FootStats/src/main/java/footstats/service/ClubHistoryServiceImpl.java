package footstats.service;

import footstats.model.ClubHistory;
import footstats.repository.ClubHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClubHistoryServiceImpl implements ClubHistoryService {

    @Autowired
    private ClubHistoryRepository clubHistoryRepository;


    @Override
    @Transactional
    public void save(ClubHistory clubHistory) {

        clubHistoryRepository.save(clubHistory);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {

        clubHistoryRepository.delete(id);
    }

    @Override
    public Iterable<ClubHistory> findAll() {

        Iterable<ClubHistory> clubHistories = clubHistoryRepository.findAll();
        if(clubHistories != null) {
            return clubHistories;
        } else {
            return null;
        }
    }

    @Override
    public ClubHistory findByid(Integer id) {

        ClubHistory clubHistory = clubHistoryRepository.findOne(id);

        if(clubHistory != null) {
            return clubHistory;
        } else {
            return null;
        }
    }
}
