package hello.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sportista")
public class Sportsman {
	
	@Id
	@Column( name = "jmbg")
	private Integer id;
	@Column( name = "ime")
	private String firstName;
	@Column( name = "prezime")
	private String lastName;
	@Column( name = "godine")
	private Integer age;
	@Column( name = "adresa_id")
	@ManyToOne
	@JoinColumn( name = "adresa_id")
	private Address address;
	@ManyToOne
	@JoinColumn( name = "klub_id")
	private Club club;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Club getClub() {
		return club;
	}
	
	public void setClub(Club club) {
		this.club = club;
	}
}
