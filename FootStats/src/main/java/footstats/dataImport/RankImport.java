package footstats.dataImport;

import footstats.model.Rank;
import footstats.service.RankService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankImport {

    final static Logger log = Logger.getLogger(StadiumImport.class);

    @Autowired
    RankService rankService;

    public void importRanks() throws InterruptedException{
        try {
            int i = 1;
            while(i <= 5) {
                Rank rank = new Rank();
                rank.setName(i + "-st");
                rankService.save(rank);
                i++;

            }
        } catch (Exception e) {
            log.debug("Got an exception!");
            log.debug(e.getMessage());
        }
    }
}
