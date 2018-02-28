package hello.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.Sponsorship;
import hello.repository.SponsorshipRepository;

@Service
public class SponsorshipServiceImp implements SponsorshipService{

	@Autowired SponsorshipRepository sponsorshipRepository;
	
	@Override
	public Iterable<Sponsorship> findAll() {
		
		Iterable<Sponsorship> sponsorship = sponsorshipRepository.findAll();
		
		if(sponsorship != null) {
			return sponsorship;
		} else {
			return null;
		}
		
	}

	@Override
	@Transactional
	public void save(Sponsorship s) {
		
		sponsorshipRepository.save(s);
		
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		
		sponsorshipRepository.deleteById(id);
		
	}

	@Override
	public Sponsorship findById(Integer id) {
		
		Sponsorship s = sponsorshipRepository.findOne(id);
		
		if(s != null) {
			return s;
		} else {
			return null;
		}

	}

}
