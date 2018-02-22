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
	private AdresaRepository AdresaRepository;
    @Autowired
	private KompanijaRepository KompanijaRepository;
    @Autowired
    private RadnikRepository RadnikRepository;
    
    
    @GetMapping(path="/all")
	public @ResponseBody Iterable<Radnik> getAllRadnik(){
		
		return RadnikRepository.findAll();
		
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
  	
  		
  		RadnikRepository.save(r);
  		return " Sacuvan Radnik u bazu ";
 }
    @GetMapping("/delete")
    public @ResponseBody String deleteRadnik (@RequestParam Integer jmbg ) {
       
    	 if(jmbg == null) 
             return " Ne postoji taj radnik ";
    	 
    	Radnik r = new Radnik();
       
        r.setJmbg(jmbg);
        

         
         RadnikRepository.delete(r);
       return "Obrisan Radnik";
          
        		 
    }
    
//    @GetMapping(path="/edit")
//	 public @ResponseBody String updateRadnik(@RequestParam Integer jmbg, 
//			 @RequestParam (required = false) String ime,
//			 @RequestParam (required = false) String prezime,
//			 @RequestParam (required = false) Integer godina, 
//			 @RequestParam (required = false) Integer adresa_id, 
//			 @RequestParam (required = false) Integer kompanija_id, 
//			 @RequestParam (required = false) String bracniStatus) {
//		 
//		 Iterable<Adresa> allAdresa = AdresaRepository.findAll();
//		 Iterable<Kompanija> allKompanija = KompanijaRepository.findAll();
//		 Iterable<Radnik> allRadnik = RadnikRepository.findAll();
//		 
//		 for (Radnik r: allRadnik ) {
//			
//				 
//				 
//			 }
//			 
//			 return " Updated Radnik ";
//			 }
//		 }
//		 return " No ID od kompanije ";
//	 }
    
    
    
    

}
