package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.model.Club;
import hello.model.League;
import hello.service.ClubService;
import hello.service.LeagueService;

@Controller
@RequestMapping(path = "/league")
public class LeagueController {
	
	@Autowired
	private LeagueService leagueService;
	@Autowired
	private ClubService clubService;
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<League> getAllLeague(){
		
		return leagueService.findAll();
	}
	
	@GetMapping(path = "/add")
	public @ResponseBody String addNewLeague(@RequestParam String name,
			@RequestParam Integer rank,
			@RequestParam String country,
			@RequestParam Integer club_id) {
		
		League l = new League();
		l.setName(name);
		l.setRank(rank);
		l.setCountry(country);
		
		Club c = clubService.findById(club_id);
		c.setId(club_id);
		
//		l.addClub(c);
		leagueService.save(l);
		
		return "Saved league";
		
	}
	
	@GetMapping(path = "/delete")
	public @ResponseBody String deleteLeague(@RequestParam Integer id) {
		
		if(id == null) {
			return "Wrong id";
		}
		
		leagueService.deleteById(id);
		return "Deleted league";
		
	}
	
	@GetMapping(path = "/update")
	public @ResponseBody String updateLeague(@RequestParam Integer id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer rank,
			@RequestParam(required = false) String country) {
		
		League l = leagueService.findById(id);
		
		if(l.getId() == id) {
			if(name != null) {
				l.setName(name);
			}
			if(rank != null) {
				l.setRank(rank);
			}
			if(country != null) {
				l.setCountry(country);
			}
			
			leagueService.save(l);
			return "Updated league";
		}
		
		return "Wrong id league";
				
	}
		
}
