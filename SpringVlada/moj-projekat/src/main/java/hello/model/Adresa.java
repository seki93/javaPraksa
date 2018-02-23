package hello.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Adresa {
	
	@Id
    private Integer adresa_id;

    private String drzava;

    private String grad;
    
    private String ulica;
    
    private Integer broj;
    
    private Integer sprat;

	public Integer getAdresa_id() {
		return adresa_id;
	}

	public void setAdresa_id(Integer adresa_id) {
		this.adresa_id = adresa_id;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public Integer getBroj() {
		return broj;
	}

	public void setBroj(Integer broj) {
		this.broj = broj;
	}

	public Integer getSprat() {
		return sprat;
	}

	public void setSprat(Integer sprat) {
		this.sprat = sprat;
	}
    



}
