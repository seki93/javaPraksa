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
    private Integer endResult;

    private Integer fouls;

    @Column(name = "halftimeresult")
    private Integer halfTimeResult;

    private Integer passes;

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

    public Integer getEndResult() {
        return endResult;
    }

    public void setEndResult(Integer endResult) {
        this.endResult = endResult;
    }

    public Integer getFouls() {
        return fouls;
    }

    public void setFouls(Integer fouls) {
        this.fouls = fouls;
    }

    public Integer getHalfTimeResult() {
        return halfTimeResult;
    }

    public void setHalfTimeResult(Integer halfTimeResult) {
        this.halfTimeResult = halfTimeResult;
    }

    public Integer getPasses() {
        return passes;
    }

    public void setPasses(Integer passes) {
        this.passes = passes;
    }
}
