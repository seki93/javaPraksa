package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.model.Address;
import hello.model.Club;
import hello.model.League;
import hello.service.AddressService;
import hello.service.ClubService;
import hello.service.LeagueService;


@Controller
@RequestMapping(path="/club")
public class ClubController {
	
	@Autowired
	private AddressService addressService;
    @Autowired
	private ClubService clubService;
    @Autowired
	private LeagueService leagueService;
        
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Club> getAllClub(){
		
		return clubService.findAll();
		
	}
    
    @GetMapping(path="/add")
	public @ResponseBody String addNewClub (@RequestParam Integer id,
			@RequestParam Integer address_id,
			@RequestParam String name, 
			@RequestParam String sport) {
		
		Club c = new Club();
		c.setId(id);
		c.setName(name);
		c.setSport(sport);
		Address a = addressService.findById(address_id);
		c.setAddress(a);
		
		clubService.save(c);
		return "Saved club";		
		
	}	
	 
	 @GetMapping(path="/delete")
	 public @ResponseBody String deleteClub (@RequestParam Integer id ) {
	       
	    	 if(id == null) 
	             return "Wrong id club";
	    	 
	    	 clubService.deleteById(id);	    	 
	    	 return "Deleted club";	          
	        		 
	 }
	 
	 @GetMapping(path="/update")
	 public @ResponseBody String updateClub(@RequestParam Integer id, 
			 @RequestParam (required = false) Integer address_id,
			 @RequestParam (required = false) String name,
			 @RequestParam (required = false) String sport,
			 @RequestParam (required = false) Integer league_id) {
		 
		Club c = clubService.findById(id);
		if (c.getId() == id) {
			 if(name != null) {
				 c.setName(name);
			 }
			 if(sport != null) {
				 c.setSport(sport);
			 }
			 if(address_id != null) {
				 Address address = new Address();
				 address = addressService.findById(address_id);
				 c.setAddress(address);				 
			 }
			 if(league_id != null) {
				 League league = new League();
				 league = leagueService.findById(league_id);
				 c.setLeague(league);				 
			 }
			 
			clubService.save(c);			 
			return "Updated club";
		
		}
		 
		 return "Wrong id club";
		 
	 }
	 
	 @GetMapping(path = "/dummy")
	 @Qualifier("Dummy")
	 public  @ResponseBody Club findByName(@RequestParam String name) {
		 
		 return clubService.findByName(name);
	 }

}
