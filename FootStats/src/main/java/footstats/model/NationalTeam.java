package footstats.model;

import javax.persistence.*;

@Entity
public class NationalTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToOne
    private Country countryl;

    @OneToMany
    private City.Competition competition;

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

    public Country getCountryl() {
        return countryl;
    }

    public void setCountryl(Country countryl) {
        this.countryl = countryl;
    }

    public City.Competition getCompetition() {
        return competition;
    }

    public void setCompetition(City.Competition competition) {
        this.competition = competition;
    }
}
