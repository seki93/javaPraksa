package footstats.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Referee extends Person{

    private Integer numberOfLicence;

    public Referee( String firstName, String lastName, Date dateOfBirth, City cityOfBirth, Integer numberOfLicence) {
        super(firstName, lastName, dateOfBirth, cityOfBirth);
        this.numberOfLicence = numberOfLicence;
    }

    public Referee() {};

    public Integer getNumberOfLicence() {
        return numberOfLicence;
    }

    public void setNumberOfLicence(Integer numberOfLicence) {
        this.numberOfLicence = numberOfLicence;
    }
}
