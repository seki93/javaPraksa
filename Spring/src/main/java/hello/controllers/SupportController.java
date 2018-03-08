package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.model.Club;
import hello.model.Support;
import hello.model.SupportCompositeKey;
import hello.model.Supporter;
import hello.model.Worker;
import hello.service.ClubService;
import hello.service.SupportService;
import hello.service.WorkerService;

@Controller
@RequestMapping(path = "/support")
public class SupportController {

	@Autowired
	private SupportService supportService;
	
	@Autowired
	private ClubService clubService;
	
	@Autowired
	private WorkerService workerService;
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Support> getAllSupport() {
		
		return supportService.findAll();
		
	}
	
	@GetMapping(path = "/add")
	public @ResponseBody String addNewSupport(@RequestParam Integer jmbg_id,
			@RequestParam Integer club_id,
			@RequestParam (required = false) String nesto) {
		
		Support s = new Support();
		SupportCompositeKey sck = new SupportCompositeKey();
	
		Worker w = workerService.findById(jmbg_id);
		sck.setJmbg_id(w);
		if(w != null) {
			s.setSck(sck);
		} else {
			return "No id worker";
		}
		
		Club c = clubService.findById(club_id);
		sck.setClub_id(c);
		if(c != null) {
			s.setSck(sck);
		} else {
			return "No id club";
		}
		
		if(nesto != null) {
//			for(Supporter se: Supporter.values()) {
//				if((se.nesto()).equals(nesto)) {
//					s.setSupporter(se);
//				}
//			}
			switch(nesto) {
			case "n":
				s.setSupporter(Supporter.NAVIJA);
				break;
			case "o":
				s.setSupporter(Supporter.OBOZAVA);
				break;
			case "p" :
				s.setSupporter(Supporter.PODRZAVA);
				System.out.println(Supporter.valueOf("n"));

				break;
			case "s":
				s.setSupporter(Supporter.SIMPATISE);
				break;
			}

		}
		supportService.save(s);
		
		return "Saved support";
		
	}
	
}
