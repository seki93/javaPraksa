package hello.model;

import javax.persistence.Column;
import javax.persistence.Id;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Aspekt {
	
	@Id
	private Integer id;
	
	@Column(name = "naziv")
	private String name;
	
	@Column(name = "pocetak")
	private String begin;
	
	@Column(name = "kraj")
	private String end;

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

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
	
}
