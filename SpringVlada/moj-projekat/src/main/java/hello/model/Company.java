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
	@Column(name = "naziv")
	private String name;	 
	@ManyToOne
	@JoinColumn(name = "adresa_id") 
	private Address address;
	
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
