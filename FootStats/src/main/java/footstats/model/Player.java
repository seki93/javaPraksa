package footstats.model;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Person person;

    @OneToOne
    private Position position;

    @OneToOne
    private Club club;

    @OneToOne
    private PlayerStats playerStats;

    @OneToOne
    private NationalTeam nationalTeam;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public PlayerStats getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(PlayerStats playerStats) {
        this.playerStats = playerStats;
    }

    public NationalTeam getNationalTeam() {
        return nationalTeam;
    }

    public void setNationalTeam(NationalTeam nationalTeam) {
        this.nationalTeam = nationalTeam;
    }
}
