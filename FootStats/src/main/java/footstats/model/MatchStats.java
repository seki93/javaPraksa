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

    private Integer cards;

    @Column(name = "endresult")
    private String endResult;

    private Integer fouls;

    @Column(name = "halftimeresult")
    private String halfTimeResult;

    private Integer passes;

    public MatchStats(Integer id, Integer assistance, Integer cards, String endResult, Integer fouls, String halfTimeResult, Integer passes) {
        this.id = id;
        this.assistance = assistance;
        this.cards = cards;
        this.endResult = endResult;
        this.fouls = fouls;
        this.halfTimeResult = halfTimeResult;
        this.passes = passes;
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

    public Integer getCards() {
        return cards;
    }

    public void setCards(Integer cards) {
        this.cards = cards;
    }

    public String getEndResult() {
        return endResult;
    }

    public void setEndResult(String endResult) {
        this.endResult = endResult;
    }

    public Integer getFouls() {
        return fouls;
    }

    public void setFouls(Integer fouls) {
        this.fouls = fouls;
    }

    public String getHalfTimeResult() {
        return halfTimeResult;
    }

    public void setHalfTimeResult(String halfTimeResult) {
        this.halfTimeResult = halfTimeResult;
    }

    public Integer getPasses() {
        return passes;
    }

    public void setPasses(Integer passes) {
        this.passes = passes;
    }
}
