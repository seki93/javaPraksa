package hello.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "liga")
public class League {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "liga_id")
	private Integer id;
	
	@Column(name = "naziv")
	private String name;
	
	@Column(name = "rang")
	private Integer rank;
	
	@Column(name = "drzava")
	private String country;
	
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

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


}
