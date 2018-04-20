package footstats.model;

import javax.persistence.*;

@Entity
@Table(name = "nationalteam")
public class NationalTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToOne
    private Country country;

    @ManyToOne
    private Competition competition;

    public NationalTeam(Integer id, String name, Country country, Competition competition) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.competition = competition;
    }

    public NationalTeam() {};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
