package footstats.model;

import javax.persistence.*;

@Entity
@Table(name = "clubhistory")
public class ClubHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Player player;

    public ClubHistory(Integer id, Player player) {
        this.id = id;
        this.player = player;
    }

    public ClubHistory() {};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
