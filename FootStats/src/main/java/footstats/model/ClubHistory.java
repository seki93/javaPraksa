package footstats.model;

import javax.persistence.*;

@Entity
public class ClubHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

<<<<<<< HEAD
    @OneToOne
=======
    @ManyToOne
>>>>>>> acaffe7166d5a6b7eb271c879029a16f9ec8c884
    private Player player;

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
