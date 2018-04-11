package footstats.service;

import footstats.model.Position;

public interface PositionService {

    public Iterable<Position> findAll();

    public Position findById(Integer id);

    public void deleteById(Integer id);

    public void save(Position p);
}
