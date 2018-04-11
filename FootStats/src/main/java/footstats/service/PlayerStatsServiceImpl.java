package footstats.service;

import footstats.model.PlayerStats;
import footstats.repository.PlayerStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PlayerStatsServiceImpl implements PlayerStatsService {

    @Autowired
    private PlayerStatsRepository playerStatsRepository;

    @Override
    @Transactional
    public void save(PlayerStats playerStats) {

        playerStatsRepository.save(playerStats);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {

        playerStatsRepository.delete(id);
    }

    @Override
    public Iterable<PlayerStats> findAll() {

        return playerStatsRepository.findAll();
    }

    @Override
    public PlayerStats findById(Integer id) {

        PlayerStats ps = playerStatsRepository.findOne(id);

        if(ps != null) {
            return ps;
        } else {
            return null;
        }
    }
}
