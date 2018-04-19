package footstats.service;

import footstats.model.Rank;

public interface RankService {

    public Iterable<Rank> findAll();

    public Rank findById(Integer id);

    public void deleteById(Integer id);

    public void save(Rank r);

    public Rank findByName(String rankName);

}
