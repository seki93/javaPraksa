package footstats.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("player")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Player extends  Person{

    @OneToOne
    private Position position;

    @OneToOne
    private Club club;

    @OneToOne
    @JoinColumn(name = "nationalteam_id")
    private NationalTeam nationalTeam;

    public Player(Position position, Club club, NationalTeam nationalTeam) {
        this.position = position;
        this.club = club;
        this.nationalTeam = nationalTeam;
    }

    public Player() {};

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

    public NationalTeam getNationalTeam() {
        return nationalTeam;
    }

    public void setNationalTeam(NationalTeam nationalTeam) {
        this.nationalTeam = nationalTeam;
    }
}
