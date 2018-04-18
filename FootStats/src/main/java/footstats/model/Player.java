package footstats.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Player extends  Person{

    @OneToOne
    private Position position;

    @OneToOne
    private Club club;

    @OneToOne
    @JoinColumn(name = "nationalteam_id")
    private NationalTeam nationalTeam;

    public Player(String firstName, String lastName, Date dateOfBirth, City cityOfBirth, Position position, Club club, NationalTeam nationalTeam) {
        super(firstName, lastName, dateOfBirth, cityOfBirth);
        this.position = position;
        this.club = club;
        this.nationalTeam = nationalTeam;
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

    public NationalTeam getNationalTeam() {
        return nationalTeam;
    }

    public void setNationalTeam(NationalTeam nationalTeam) {
        this.nationalTeam = nationalTeam;
    }
}
