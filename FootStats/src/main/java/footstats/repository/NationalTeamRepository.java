package footstats.repository;

import footstats.model.NationalTeam;
import jdk.nashorn.internal.objects.NativeArguments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NationalTeamRepository extends CrudRepository<NationalTeam, Integer> {

    public void deleteById(Integer id);

    public NationalTeam findByName(String nationalTeamName);

    public List<NationalTeam> findNationalTeamByName(String nationalTeamName);
}
