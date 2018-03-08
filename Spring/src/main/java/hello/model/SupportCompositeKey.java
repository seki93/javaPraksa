package hello.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class SupportCompositeKey implements Serializable {
	
	@ManyToOne
	@JoinColumn(name = "jmbg")
	private Worker jmbg_id;
	
	@ManyToOne
	@JoinColumn(name = "klub_id")
	private Club club_id;

	public Worker getJmbg_id() {
		return jmbg_id;
	}

	public void setJmbg_id(Worker jmbg_id) {
		this.jmbg_id = jmbg_id;
	}

	public Club getClub_id() {
		return club_id;
	}

	public void setClub_id(Club club_id) {
		this.club_id = club_id;
	}
	
	

}
