package hello.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sponzorstvo")
public class Sponsorship {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sponzorstvo_id")
	private Integer id;
	
	@Column(name = "kompanija_id")
	private Company company;
	
	@Column(name = "klub_id")
	private Club club;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
	
}
