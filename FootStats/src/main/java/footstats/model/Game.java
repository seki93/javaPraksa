package footstats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Date date;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "awayclub_id")
    private Club awayClub;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "homeclub_id")
    private Club homeClub;

    @OneToOne
    @JoinColumn(name = "matchstats_id")
    private MatchStats matchStats;

    @ManyToOne
    @JoinColumn(name = "referee_id")
    private Referee referee;

    public Game() {
    }

    public Game(Integer id, Club awayClub, Club homeClub, MatchStats matchStats, Referee referee,  Date date) {
        this.id = id;
        this.awayClub = awayClub;
        this.homeClub = homeClub;
        this.matchStats = matchStats;
        this.referee = referee;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Club getAwayClub() {
        return awayClub;
    }

    public void setAwayClub(Club awayClub) {
        this.awayClub = awayClub;
    }

    public Club getHomeClub() {
        return homeClub;
    }

    public void setHomeClub(Club homeClub) {
        this.homeClub = homeClub;
    }

    public MatchStats getMatchStats() {
        return matchStats;
    }

    public void setMatchStats(MatchStats matchStats) {
        this.matchStats = matchStats;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

