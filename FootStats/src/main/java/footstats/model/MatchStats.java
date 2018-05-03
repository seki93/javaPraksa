package footstats.model;

import javax.persistence.*;

@Entity
@Table(name = "matchstats")
public class MatchStats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "assistance")
    private Integer assistance;

    private Integer cards_hometeam;

    private Integer cards_awayteam;

    @Column(name = "endresult")
    private String endResult;

    private Integer fouls_hometeam;

    private Integer fouls_awayteam;

    @Column(name = "halftimeresult")
    private String halfTimeResult;

    private Float passPercent_hometeam;

    private Float passPercent_awayteam;


    public MatchStats(Integer id, Integer assistance, Integer cards_hometeam, Integer cards_awayteam, String endResult, Integer fouls_hometeam, Integer fouls_awayteam, String halfTimeResult, Float passPercent_hometeam, Float passPercent_awayteam) {
        this.id = id;
        this.assistance = assistance;
        this.cards_hometeam = cards_hometeam;
        this.cards_awayteam = cards_awayteam;
        this.endResult = endResult;
        this.fouls_hometeam = fouls_hometeam;
        this.fouls_awayteam = fouls_awayteam;
        this.halfTimeResult = halfTimeResult;
        this.passPercent_hometeam = passPercent_hometeam;
        this.passPercent_awayteam = passPercent_awayteam;
    }

    public MatchStats() {};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAssistance() {
        return assistance;
    }

    public void setAssistance(Integer assistance) {
        this.assistance = assistance;
    }

    public Integer getCards_hometeam() {
        return cards_hometeam;
    }

    public void setCards_hometeam(Integer cards_hometeam) {
        this.cards_hometeam = cards_hometeam;
    }

    public Integer getCards_awayteam() {
        return cards_awayteam;
    }

    public void setCards_awayteam(Integer cards_awayteam) {
        this.cards_awayteam = cards_awayteam;
    }

    public String getEndResult() {
        return endResult;
    }

    public void setEndResult(String endResult) {
        this.endResult = endResult;
    }

    public Integer getFouls_hometeam() {
        return fouls_hometeam;
    }

    public void setFouls_hometeam(Integer fouls_hometeam) {
        this.fouls_hometeam = fouls_hometeam;
    }

    public Integer getFouls_awayteam() {
        return fouls_awayteam;
    }

    public void setFouls_awayteam(Integer fouls_awayteam) {
        this.fouls_awayteam = fouls_awayteam;
    }

    public String getHalfTimeResult() {
        return halfTimeResult;
    }

    public void setHalfTimeResult(String halfTimeResult) {
        this.halfTimeResult = halfTimeResult;
    }

    public Float getPassPercent_hometeam() {
        return passPercent_hometeam;
    }

    public void setPassPercent_hometeam(Float passPercent_hometeam) {
        this.passPercent_hometeam = passPercent_hometeam;
    }

    public Float getPassPercent_awayteam() {
        return passPercent_awayteam;
    }

    public void setPassPercent_awayteam(Float passPercent_awayteam) {
        this.passPercent_awayteam = passPercent_awayteam;
    }
}
