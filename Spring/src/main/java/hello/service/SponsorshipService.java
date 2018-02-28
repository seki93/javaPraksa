package hello.service;

import hello.model.Sponsorship;

public interface SponsorshipService {

	public Iterable<Sponsorship> findAll();

	public void save(Sponsorship s);

	public void deleteById(Integer id);

	public Sponsorship findById(Integer id);

}
