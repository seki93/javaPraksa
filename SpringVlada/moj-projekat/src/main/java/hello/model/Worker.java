package hello.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "radnik")
public class Worker {
 
	
	@Id
	@Column( name = "jmbg")
	private Integer id;
	
	private String ime;
	
	private String prezime;
	
	private int godine;
	
	 @ManyToOne
     @JoinColumn(name = "kompanija_id") 
	private Company kompanija;
	

	@ManyToOne
	@JoinColumn(name = "adresa_id") 
    private Address adresa;
	
	private String bracniStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getGodine() {
		return godine;
	}

	public void setGodine(int godine) {
		this.godine = godine;
	}

	public Company getKompanija() {
		return kompanija;
	}

	public void setKompanija(Company kompanija) {
		this.kompanija = kompanija;
	}

	public Address getAdresa() {
		return adresa;
	}

	public void setAdresa(Address adresa) {
		this.adresa = adresa;
	}

	public String getBracniStatus() {
		return bracniStatus;
	}

	public void setBracniStatus(String bracniStatus) {
		this.bracniStatus = bracniStatus;
	}
	
	
	
}
