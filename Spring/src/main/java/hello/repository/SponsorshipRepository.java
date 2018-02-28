package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.Sponsorship;

public interface SponsorshipRepository extends CrudRepository<Sponsorship, Integer> {

	public void deleteById(Integer id);
	
}
