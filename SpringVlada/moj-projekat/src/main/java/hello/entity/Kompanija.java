package hello.entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Kompanija{

	
	
	@Id
	 private Integer kompanija_id;
	
	 private String naziv;
	 
	 @ManyToOne
	 @JoinColumn(name = "adresa_id") 
	 private Adresa adresa;
	 
	 
	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Integer getKompanija_id() {
		return kompanija_id;
	}

	public void setKompanija_id(Integer kompanija_id) {
		this.kompanija_id = kompanija_id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	 
	 
	
}
