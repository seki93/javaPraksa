package footstats.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "dateofbirth")
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "cityofbirth_id")
    private City cityOfBirth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public City getCityOfBirth() {
        return cityOfBirth;
    }

    public void setCityOfBirth(City cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }
}
