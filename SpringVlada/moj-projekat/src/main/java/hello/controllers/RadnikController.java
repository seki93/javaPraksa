package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.entity.Adresa;
import hello.entity.Kompanija;
import hello.entity.Radnik;
import hello.repos.AdresaRepository;
import hello.repos.KompanijaRepository;
import hello.repos.RadnikRepository;

@Controller
@RequestMapping(path="/radnik")
public class RadnikController {
	
	
	@Autowired
	private AdresaRepository adresaRepository;
    @Autowired
	private KompanijaRepository kompanijaRepository;
    @Autowired
    private RadnikRepository radnikRepository;
    
    
    @GetMapping(path="/all")
	public @ResponseBody Iterable<Radnik> getAllRadnik(){
		
		return radnikRepository.findAll();
		
	}
    
   
    @GetMapping(path="/add")
  	public @ResponseBody String addNewRadnik (@RequestParam Integer jmbg, @RequestParam String ime, @RequestParam String prezime, @RequestParam Integer godine, @RequestParam Integer adresa_id, @RequestParam Integer kompanija_id, @RequestParam String bracniStatus ) {
  		
  		Radnik r = new Radnik();

  		r.setJmbg(jmbg);
  		r.setIme(ime);
  		r.setPrezime(prezime);
  		r.setGodine(godine);
  		r.setBracniStatus(bracniStatus);
  		
  		Adresa a = new Adresa();
  		a.setAdresa_id(adresa_id);
  		a.getAdresa_id();
  		
  		Kompanija k = new Kompanija();
  		k.setKompanija_id(kompanija_id);
  		k.getKompanija_id();
  		
  		r.setAdresa(a);
  		r.setKompanija(k);
  	
  		
  		radnikRepository.save(r);
  		return " Sacuvan Radnik u bazu ";
 }
    @GetMapping("/delete")
    public @ResponseBody String deleteRadnik (@RequestParam Integer jmbg ) {
       
    	 if(jmbg == null) 
             return " Ne postoji taj radnik ";
    	 
    	Radnik r = new Radnik();
       
        r.setJmbg(jmbg);
        

         
         radnikRepository.delete(r);
       return "Obrisan Radnik";
          
        		 
    }
    
    @GetMapping(path = "/update")
	public @ResponseBody String updateRadnik(@RequestParam Integer jmbg,
			@RequestParam(required = false) String ime,
			@RequestParam(required = false) String prezime,
			@RequestParam(required = false) Integer godine,
			@RequestParam(required = false) Integer adresa_id,
			@RequestParam(required = false) Integer kompanija_id,
			@RequestParam(required = false) String bracni_status) {
		
		for(Radnik r: radnikRepository.findAll()) {
			if(r.getJmbg() == jmbg) {
				if(ime != null) {
					r.setIme(ime);
				}
				if(prezime != null) {
					r.setPrezime(prezime);
				}
				if(godine != null) {
					r.setGodine(godine);
				}
				if(adresa_id != null) {
					for(Adresa a: adresaRepository.findAll()) {
						if(a.getAdresa_id() == adresa_id) {
							r.setAdresa(a);
						}
					}
				}
				if(kompanija_id != null) {
					for(Kompanija k: kompanijaRepository.findAll()) {
						if(k.getKompanija_id() == kompanija_id) {
							r.setKompanija(k);
						}
					}
				}
				return "Radnik je update!";
			}
		}
		
		return "Ne postoji radnik, da bi mogao da se updatejtuje!";
		
	}
    
    
    
    

}
