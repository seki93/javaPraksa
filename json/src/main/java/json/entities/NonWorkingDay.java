package json.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "non_working_day")
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "non_working_day_seq")
public class NonWorkingDay extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "non_work_date")
    private Date nonWorkDate;

    // TODO: NonWorkingDay depends on currency also

    @Column(name = "description")
    private String description;

    public Date getNonWorkDate() {
	return nonWorkDate;
    }

    public void setNonWorkDate(Date nonWorkDate) {
	this.nonWorkDate = nonWorkDate;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

}
