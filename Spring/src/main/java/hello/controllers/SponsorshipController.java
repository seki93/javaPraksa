package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.model.Club;
import hello.model.Company;
import hello.model.Sponsorship;
import hello.service.ClubService;
import hello.service.CompanyService;
import hello.service.SponsorshipService;

@Controller
@RequestMapping(path = "/sponsorship")
public class SponsorshipController {

	@Autowired
	private SponsorshipService sponsorshipService;
	
	@Autowired
	private ClubService clubService;
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Sponsorship> getAllSponsorship() {
		
		return sponsorshipService.findAll();
		
	}
	
	@GetMapping(path = "/add")
	public @ResponseBody String addNewSponsorShip(@RequestParam Integer id,
			@RequestParam Integer company_id,
			@RequestParam Integer club_id) {
		
		Sponsorship s = new Sponsorship();
		s.setId(id);
		Company company = companyService.findById(company_id);
		s.setCompany(company);
		Club club = clubService.findById(club_id);
		s.setClub(club);
		sponsorshipService.save(s);
		
		return "Saved Sponsorship";
		
	}
	
	@GetMapping(path = "/delete")
	public @ResponseBody String deleteSponsorship(@RequestParam Integer id) {
		
		if(id == null) {
			return "Wrong id";
		}
		
		sponsorshipService.deleteById(id);
		return "Deleted sponsorship";
		
	}
	
	@GetMapping(path = "/update")
	public @ResponseBody String updateLeague(@RequestParam Integer id,
			@RequestParam(required = false) Integer company_id,
			@RequestParam(required = false) Integer club_id) {
		
		Sponsorship s = sponsorshipService.findById(id);
		
		if(s.getId() == id) {
			if(company_id != null) {
				Company company = companyService.findById(company_id);
				s.setCompany(company);
			}
			if(club_id != null) {
				Club club = clubService.findById(club_id);
				s.setClub(club);
			}
			
			sponsorshipService.save(s);
			return "Updated sponsorship";
		}
		
		return "Wrong id sponsorship";
				
	}
	
}
