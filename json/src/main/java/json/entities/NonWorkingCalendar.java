package json.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "non_working_calendar")
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "non_working_calendar_seq")
public class NonWorkingCalendar extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private Integer year;

    // only when import calendar per market rate mark (LIBOR, EURIBOR...)
    //@OneToOne
    //private Currency currency;

    @Column(name = "buyer_calendar")
    private boolean buyerCalendar;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "non_work_cal_id")
    private List<NonWorkingDay> nonWorkingDays;

    public Country getCountry() {
	return country;
    }

    public void setCountry(Country country) {
	this.country = country;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Integer getYear() {
	return year;
    }

    public void setYear(Integer year) {
	this.year = year;
    }

    public List<NonWorkingDay> getNonWorkingDays() {
	return nonWorkingDays;
    }

    public void setNonWorkingDays(List<NonWorkingDay> nonWorkingDays) {
	this.nonWorkingDays = nonWorkingDays;
    }

    public boolean getBuyerCalendar() {
	return buyerCalendar;
    }

    public void setBuyerCalendar(boolean buyerCalendar) {
	this.buyerCalendar = buyerCalendar;
    }

}
