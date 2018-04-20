package footstats.model;

import javax.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "awayclub_id")
    private Club awayClub;

    @OneToOne
    @JoinColumn(name = "homeclub_id")
    private Club homeClub;

    @OneToOne
    @JoinColumn(name = "matchstats_id")
    private MatchStats matchStats;

    @ManyToOne
    @JoinColumn(name = "referee_id")
    private Referee referee;

    public Game(Integer id, Club awayClub, Club homeClub, MatchStats matchStats, Referee referee) {
        this.id = id;
        this.awayClub = awayClub;
        this.homeClub = homeClub;
        this.matchStats = matchStats;
        this.referee = referee;
    }

    public Game() {};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Club getHomeClub() {
        return homeClub;
    }

    public void setHomeClub(Club homeClub) {
        this.homeClub = homeClub;
    }

    public Club getAwayClub() {
        return awayClub;
    }

    public void setAwayClub(Club awayClub) {
        this.awayClub = awayClub;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public MatchStats getMatchStats() {
        return matchStats;
    }

    public void setMatchStats(MatchStats matchStats) {
        this.matchStats = matchStats;
    }
}
