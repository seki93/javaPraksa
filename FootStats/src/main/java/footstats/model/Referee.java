package footstats.model;

import javax.persistence.*;

@Entity(name = "referee")
@DiscriminatorValue("referee")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Referee extends Person{

    public Referee() {
    }
}
