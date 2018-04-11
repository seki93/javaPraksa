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
        Iterable<Position> positions = positionRepository.findAll();

        if(positions != null) return positions;
        else return null;
    }

    @Override
    public Position findById(Integer id) {
        Position p = positionRepository.findOne(id);

        if(p != null) return p;
        else return null;
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        positionRepository.delete(id);
    }

    @Override
    @Transactional
    public void save(Position p) {
        positionRepository.save(p);
    }
}
