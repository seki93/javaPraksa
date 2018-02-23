package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import hello.model.Adresa;
import hello.model.Kompanija;
import hello.repository.AdresaRepository;
import hello.repository.KompanijaRepository;
import hello.service.KompanijeService;

@Controller
@RequestMapping(path="/company")
public class KompanijaController {

	@Autowired
	private AdresaRepository adresaRepository;
    @Autowired
	private KompanijaRepository kompanijaRepository;
    
    @Autowired
	private KompanijeService kompanijeService;
    
    
    @GetMapping(path="/add")
	public @ResponseBody String addNewKompanija (@RequestParam Integer kompanija_id, @RequestParam String naziv, @RequestParam Integer adresa_id) {
		
		Kompanija k = new Kompanija();
		k.setId(kompanija_id);
		k.setNaziv(naziv);
		Adresa a = new Adresa();
		a.setAdresa_id(adresa_id);
		a.getAdresa_id();
		k.setAdresa(a);;
		
		kompanijaRepository.save(k);
		return " Sacuvana Kompanija u bazu ";
		
		
		
	}
    
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Kompanija> getAllKompanija(){
		
		return kompanijaRepository.findAll();
		
	}
	
	 
	 @GetMapping(path="/update")
	 public @ResponseBody String updateKompanija(@RequestParam Integer kompanija_id, 
			 @RequestParam (required = false) String naziv,
			 @RequestParam (required = false) Integer adresa_id ) {
		 
		 Iterable<Kompanija> allKompanija = kompanijaRepository.findAll();
		 
		 for (Kompanija a: allKompanija ) {
			 if (a.getId() == kompanija_id) {
			 if(naziv != null) a.setNaziv(naziv);
			 if(adresa_id != null) {
				 Adresa adresa = new Adresa();
				 adresa = adresaRepository.findOne(adresa_id);
				 adresa.setAdresa_id(adresa_id);
				 a.setAdresa(adresa);
				 
				 
			 }
			 kompanijaRepository.save(a);
			 return " Updated kompanija ";
			 }
		 }
		 return " No ID od kompanije ";
	 }
	 
	 @GetMapping("/delete")
	    public @ResponseBody String deleteKompanija (@RequestParam Integer kompanija_id ) {
	       
	    	 if(kompanija_id == null) 
	             return " Ne postoji ta kompanija ";
	    	 
	    	 kompanijeService.deleteById(kompanija_id);
	    	 
	       return "Obrisano";
	          
	        		 
	    }
	
}
