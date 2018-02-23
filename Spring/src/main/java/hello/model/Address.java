package hello.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "adresa")
public class Address {
	
	@Id
	@Column( name = "adresa_id")
    private Integer id;
	
	@Column(name = "drzava")
    private String country;
	
	@Column(name = "grad")
    private String city;
	
	@Column(name = "ulica")
    private String street;
	
	@Column(name = "broj")
    private Integer number;
	
	@Column(name = "sprat")
    private Integer floor;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public Integer getFloor() {
		return floor;
	}
	
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
    	
}
