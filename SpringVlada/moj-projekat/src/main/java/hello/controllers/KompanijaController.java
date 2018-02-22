package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.entity.Adresa;
import hello.entity.Kompanija;
import hello.repos.AdresaRepository;
import hello.repos.KompanijaRepository;

@Controller
@RequestMapping(path="/komp")
public class KompanijaController {

	@Autowired
	private AdresaRepository AdresaRepository;
    @Autowired
	private KompanijaRepository KompanijaRepository;
    
    
    @GetMapping(path="/addKomp")
	public @ResponseBody String addNewKompanija (@RequestParam Integer kompanija_id, @RequestParam String naziv, @RequestParam Integer adresa_id) {
		
		Kompanija k = new Kompanija();
		k.setKompanija_id(kompanija_id);
		k.setNaziv(naziv);
		Adresa a = new Adresa();
		a.setAdresa_id(adresa_id);
		a.getAdresa_id();
		k.setAdresa(a);;
		
		KompanijaRepository.save(k);
		return " Sacuvana Kompanija u bazu ";
		
		
		
	}
    
	@GetMapping(path="/allKompanija")
	public @ResponseBody Iterable<Kompanija> getAllKompanija(){
		
		return KompanijaRepository.findAll();
		
	}
	
	 
	 @GetMapping(path="/editKomp")
	 public @ResponseBody String updateKompanija(@RequestParam Integer kompanija_id, 
			 @RequestParam (required = false) String naziv,
			 @RequestParam (required = false) Integer adresa_id ) {
		 
		 Iterable<Adresa> allAdresa = AdresaRepository.findAll();
		 Iterable<Kompanija> allKompanija = KompanijaRepository.findAll();
		 
		 for (Kompanija a: allKompanija ) {
			 if (a.getKompanija_id() == kompanija_id) {
			 if(naziv != null) a.setNaziv(naziv);
			 if(adresa_id != null) {
				 Adresa adresa = new Adresa();
				 adresa = AdresaRepository.findOne(adresa_id);
				 adresa.setAdresa_id(adresa_id);
				 a.setAdresa(adresa);
				 
				 
			 }
			 KompanijaRepository.save(a);
			 return " Updated kompanija ";
			 }
		 }
		 return " No ID od kompanije ";
	 }
	 
	 @GetMapping("/deleteKomp")
	    public @ResponseBody String deleteKompanija (@RequestParam Integer kompanija_id ) {
	       
	    	 if(kompanija_id == null) 
	             return " Ne postoji ta kompanija ";
	    	 
	    	Kompanija k = new Kompanija();
	       
	         k.setKompanija_id(kompanija_id);

	         
	         KompanijaRepository.delete(k);
	       return "Obrisano";
	          
	        		 
	    }
	
}
