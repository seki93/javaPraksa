package footstats.service;

import footstats.model.Position;
import footstats.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PositionServiceImpl implements  PositionService {

    @Autowired
    PositionRepository positionRepository;

    @Override
    public Iterable<Position> findAll() {
        return null;
    }

    @Override
    public Position findById(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {

    }

    @Override
    @Transactional
    public void save(Position p) {

    }
}
