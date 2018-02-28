package hello.model;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "kompanija")
public class Company{
	
	@Id
	@Column(name = "kompanija_id")
	private Integer id;
	
	@Column(name = "naziv")
	private String name;	 
	
	@ManyToOne
	@JoinColumn(name = "adresa_id") 
	private Address address;
	
	@ManyToMany
	private Set<Club> clubs;
	
	public Set<Club> getClubs() {
		return clubs;
	}

	public void setClubs(Set<Club> clubs) {
		this.clubs = clubs;
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
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	} 
	
}
