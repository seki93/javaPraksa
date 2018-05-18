package footstats.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToOne
    private Country country;

    private Integer rank;

    @ManyToMany(mappedBy = "competitions")
    private Set<NationalTeam> nationalTeams;

    public Competition(Integer id, String name, Country country, Integer rank, Set<NationalTeam> nationalTeams) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.rank = rank;
        this.nationalTeams = nationalTeams;
    }

    public Competition() {};

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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Set<NationalTeam> getNationalTeams() {
        return nationalTeams;
    }

    public void setNationalTeams(Set<NationalTeam> nationalTeams) {
        this.nationalTeams = nationalTeams;
    }

    public void addNationalTeam(NationalTeam nationalTeam){
        this.nationalTeams.add(nationalTeam);
    }
}