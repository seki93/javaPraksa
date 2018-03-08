package hello.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "navijanje")
public class Support {
	
	@EmbeddedId
	private SupportCompositeKey sck;
	
	public SupportCompositeKey getSck() {
		return sck;
	}

	public void setSck(SupportCompositeKey sck) {
		this.sck = sck;
	}

	@Column(name = "simpatizer")
	@Enumerated(EnumType.ORDINAL)
	private Supporter supporter;

	public Supporter getSupporter() {
		return supporter;
	}

	public void setSupporter(Supporter supporter) {
		this.supporter = supporter;
	}

	
	
	

}
