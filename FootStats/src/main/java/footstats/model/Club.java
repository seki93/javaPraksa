package footstats.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "club_competition", joinColumns = @JoinColumn(name = "id_club", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_competition", referencedColumnName = "id"))
    @JsonIgnore
    private Set<Competition> competitionSet = new HashSet<>();

    @OneToOne
    private City city;

    @OneToOne
    private Stadium stadium;

    public Club(Integer id, String name, Set<Competition> competition, City city, Stadium stadium) {
        this.id = id;
        this.name = name;
        this.competitionSet = competition;
        this.city = city;
        this.stadium = stadium;
    }

    public Club() {};

    public void addCompetition(Competition competition){
        this.competitionSet.add(competition);
    }

    public Set<Competition> getCompetitionSet() {
        return competitionSet;
    }

    public void setCompetitionSet(Set<Competition> competitionSet) {
        this.competitionSet = competitionSet;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }
}
