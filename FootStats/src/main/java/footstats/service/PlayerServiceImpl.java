package footstats.service;

import footstats.model.Player;
import footstats.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    @Transactional
    public void save(Player player) {

        playerRepository.save(player);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {

        playerRepository.delete(id);

    }

    @Override
    public Iterable<Player> findAll() {

        Iterable<Player> players = playerRepository.findAll();
        if(players != null) {
            return players;
        } else {
            return null;
        }
    }

    @Override
    public Player findById(Integer id) {

        Player p = playerRepository.findOne(id);

        if(p != null) {
            return p;
        } else {
            return null;
        }
    }
}
