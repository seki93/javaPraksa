package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.entity.Adresa;
import hello.repos.AdresaRepository;
import hello.repos.KompanijaRepository;


@Controller
@RequestMapping(path="/adresa")
public class AdresaController {

	
	@Autowired
	private AdresaRepository adresaRepository;
    @Autowired
	private KompanijaRepository kompanijaRepository;
    
    
    
    @GetMapping(path="/add")
    public @ResponseBody String addNewAdresa (@RequestParam Integer adresa_id, @RequestParam String drzava
			, @RequestParam String grad, @RequestParam String ulica, @RequestParam Integer broj, @RequestParam Integer sprat) {
		
		Adresa a = new Adresa();
		a.setAdresa_id(adresa_id);
		a.setDrzava(drzava);
		a.setGrad(grad);
		a.setUlica(ulica);
		a.setBroj(broj);
		a.setSprat(sprat);

		adresaRepository.save(a);
		return "Saved";
	}
    
    @GetMapping(path="/all")
	public @ResponseBody Iterable<Adresa> getAllAdresa() {
		
		return adresaRepository.findAll();
	}
    
    
    @GetMapping(path="/edit")
	 public @ResponseBody String updateAdresa (@RequestParam Integer adresa_id,
	   @RequestParam(required = false) String drzava,
	   @RequestParam(required = false) String grad,
	   @RequestParam(required = false) String ulica,
	   @RequestParam(required = false) Integer broj,
	   @RequestParam(required = false) Integer sprat) {
	  
	  Iterable<Adresa> sveAdrese = adresaRepository.findAll();
	  
	  for(Adresa a: sveAdrese) {
	   if(a.getAdresa_id() == adresa_id) {
	    if(drzava != null) a.setDrzava(drzava);
	    if(grad != null) a.setGrad(grad);
	    if(ulica != null) a.setUlica(ulica);
	    if(broj != null) a.setBroj(broj);
	    if(sprat != null) a.setSprat(sprat);
	    adresaRepository.save(a);
	    return "Apdejtovana adresa!";
	   }
	  }
	  
	  return "Ne postoji dati id!";
	 }
    
    @GetMapping("/delete")
    public @ResponseBody String deleteAdresa (@RequestParam Integer adresa_id ) {
       
    	 if(adresa_id == null) 
             return " Ne postoji ta adresa ";
    	 
    	Adresa c = new Adresa();
       
         c.setAdresa_id(adresa_id);

         
         adresaRepository.delete(c);
       return "Obrisano";
          
        		 
    }
}
