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
@Table(name = "klub")
public class Club {
   
	@Id
	@Column(name = "klub_id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "adresa_id")
	private Address address;
	
	@ManyToOne
	@JoinColumn(name = "liga_id")
	private League league;
	
	@Column(name = "naziv")
	private String name;
	
	@Column(name = "sport")
	private String sport;
	
	@ManyToMany
	@Column(name = "klub_id")
	private Set<Company> companies; 
	
	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSport() {
		return sport;
	}
	
	public void setSport(String sport) {
		this.sport = sport;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}
	
}
