package hello.service;

import hello.model.Support;

public interface SupportService {
	
	public Iterable<Support> findAll();

	public void save(Support s);

}
