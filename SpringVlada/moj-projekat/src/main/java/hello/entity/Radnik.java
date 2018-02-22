package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Radnik {
 
	
	@Id
	private Integer jmbg;
	
	private String ime;
	
	private String prezime;
	
	private int godine;
	
	 @ManyToOne
     @JoinColumn(name = "kompanija_id") 
	private Kompanija kompanija;
	

	@ManyToOne
	@JoinColumn(name = "adresa_id") 
    private Adresa adresa;
	
	private String bracniStatus;

	public Integer getJmbg() {
		return jmbg;
	}

	public void setJmbg(Integer jmbg) {
		this.jmbg = jmbg;
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

	public Kompanija getKompanija() {
		return kompanija;
	}

	public void setKompanija(Kompanija kompanija) {
		this.kompanija = kompanija;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public String getBracniStatus() {
		return bracniStatus;
	}

	public void setBracniStatus(String bracniStatus) {
		this.bracniStatus = bracniStatus;
	}
	
	
	
}
