package footstats.model;

import javax.persistence.*;

@Entity
@Table(name = "playerstats")
public class PlayerStats {

    @OneToOne
    @JoinColumn(table="player", referencedColumnName = "id")
    private Integer playerId;

    private Integer goals;

    private Integer assistance;

    private Integer fouls;

    private Integer cards;

    private Integer passes;

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getAssistance() {
        return assistance;
    }

    public void setAssistance(Integer assistance) {
        this.assistance = assistance;
    }

    public Integer getFouls() {
        return fouls;
    }

    public void setFouls(Integer fouls) {
        this.fouls = fouls;
    }

    public Integer getCards() {
        return cards;
    }

    public void setCards(Integer cards) {
        this.cards = cards;
    }

    public Integer getPasses() {
        return passes;
    }

    public void setPasses(Integer passes) {
        this.passes = passes;
    }
}
