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
	@Column(name = "ime")
	private String firstName;
	@Column(name = "prezime")
	private String lastName;
	@Column(name = "godine")
	private int age;
	
	@ManyToOne
    @JoinColumn(name = "kompanija_id") 
	private Company kompanija;
	
	@ManyToOne
	@JoinColumn(name = "adresa_id") 
    private Address adresa;
	
	@Column(name = "")
	private String bracniStatus;
	
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
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
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
