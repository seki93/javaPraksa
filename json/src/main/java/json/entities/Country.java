package json.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "country")
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "country_seq")
@SQLDelete(sql = "UPDATE country SET deleted = true WHERE id = ? and version = ?")
@Where(clause = "deleted <> true")
public class Country extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "*Please provide country code")
    @Size(min = 3, max = 3, message = "Country Code should have 3 character")
    @Column(name = "country_code")
    private String countryCode;

    @NotEmpty(message = "*Please provide country name")
    @Column(name = "name")
    private String name;

    @Column(name = "use_for_calendar")
    private boolean useForCalendar;

    public Country() {
	super();
    }

    public Country(String countryCode, String name) {
	super();
	this.countryCode = countryCode;
	this.name = name;
    }

    public String getCountryCode() {
	return countryCode;
    }

    public void setCountryCode(String countryCode) {
	this.countryCode = countryCode;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Country other = (Country) obj;
	if (countryCode == null) {
	    if (other.countryCode != null)
		return false;
	} else if (!countryCode.equals(other.countryCode))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    public boolean isUseForCalendar() {
	return useForCalendar;
    }

    public void setUseForCalendar(boolean useForCalendar) {
	this.useForCalendar = useForCalendar;
    }

}
