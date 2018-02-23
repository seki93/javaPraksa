package hello.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "kompanija")
public class Company{

	
	
	@Id
	@Column(name = "kompanija_id")
	 private Integer id;
	
	 private String naziv;
	 
	 @ManyToOne
	 @JoinColumn(name = "adresa_id") 
	 private Address adresa;
	 
	 
	public Address getAdresa() {
		return adresa;
	}

	public void setAdresa(Address adresa) {
		this.adresa = adresa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	 
	 
	
}
