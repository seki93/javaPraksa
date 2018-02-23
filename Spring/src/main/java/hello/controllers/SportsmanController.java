package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.model.Address;
import hello.model.Club;
import hello.model.Sportsman;
import hello.service.AddressService;
import hello.service.ClubService;
import hello.service.SportsmanService;

@Controller
@RequestMapping(path = "/sportsman")
public class SportsmanController {
	
	@Autowired
	private SportsmanService sportsmanService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private ClubService clubService;
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Sportsman> getAllSportsman() {
		
		return sportsmanService.findAll();
		
	}
	
	@GetMapping(path = "/add")
	public @ResponseBody String addNewSportsman (@RequestParam Integer id, 
			@RequestParam String firstName, 
			@RequestParam String lastName,
			@RequestParam Integer age,
			@RequestParam Integer address_id,
			@RequestParam Integer club_id) {
		
		Sportsman s = new Sportsman();
		s.setId(club_id);
		s.setFirstName(firstName);
		s.setLastName(lastName);
		s.setAge(age);
		Address a = addressService.findById(address_id);
		s.setAddress(a);
		Club c = clubService.findById(club_id);
		s.setClub(c);
		
		sportsmanService.save(s);
		return "Saved sportsman";
		
	}
	
	@GetMapping(path = "/delete")
	public @ResponseBody String deleteSportsman(@RequestParam Integer id) {
		
		if(id == null) {
			return "Wrong id sportsman";
		} else {
			sportsmanService.deleteById(id);
			return "Deleted sportsman";
		}
		
	}
	
	@GetMapping(path = "/update")
	public @ResponseBody String updateSportsman (@RequestParam Integer id, 
			@RequestParam(required = false) String firstName, 
			@RequestParam(required = false) String lastName,
			@RequestParam(required = false) Integer age,
			@RequestParam(required = false) Integer address_id,
			@RequestParam(required = false) Integer club_id) {
		
		Sportsman s = sportsmanService.findById(id);
		if(s != null) {
			if(firstName != null) {
				s.setFirstName(firstName);
			}
			if(lastName != null) {
				s.setLastName(lastName);
			}
			if(age != null) {
				s.setAge(age);
			}
			if(address_id != null) {
				Address a = addressService.findById(address_id);
				s.setAddress(a);
			}
			if(club_id != null) {
				Club c = clubService.findById(club_id);
				s.setClub(c);
			}
			
			sportsmanService.save(s);
			return "Updated sportsman";
		}
		
		return "Wrong id sportsman";
		
	}

}
