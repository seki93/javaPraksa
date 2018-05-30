package footstats.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "nationalteam")
public class NationalTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToOne
    private Country country;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "nationalteam_competitions",
            joinColumns = @JoinColumn(name = "nationalteam_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "competition_id", referencedColumnName = "id"))
    private Set<Competition> competitions = new HashSet<>();

    public NationalTeam(Integer id, String name, Country country, Set<Competition> competitions) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.competitions = competitions;
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

    public Set<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Set<Competition> competitions) {
        this.competitions = competitions;
    }

    public void addCompetition(Competition competition){
        this.competitions.add(competition);
    }
}
