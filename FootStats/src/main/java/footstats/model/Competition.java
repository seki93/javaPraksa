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

    @ManyToMany(mappedBy = "competitionSet")
    private Set<Club> clubSet;

    @ManyToMany(mappedBy = "competitions")
    private Set<NationalTeam> nationalTeams;

    public Competition(Integer id, String name, Country country, Integer rank) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.rank = rank;
    }

    public Competition() {};

    public Set<Club> getClubSet() {
        return clubSet;
    }

    public void setClubSet(Set<Club> clubSet) {
        this.clubSet = clubSet;
    }

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

}