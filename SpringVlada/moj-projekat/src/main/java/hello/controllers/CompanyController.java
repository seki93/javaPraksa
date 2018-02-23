package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import hello.model.Address;
import hello.model.Company;
import hello.repository.AddressRepository;
import hello.repository.CompanyRepository;
import hello.service.CompanyService;

@Controller
@RequestMapping(path="/company")
public class CompanyController {

	@Autowired
	private AddressRepository adresaRepository;
    @Autowired
	private CompanyRepository kompanijaRepository;
    
    @Autowired
	private CompanyService kompanijeService;
    
    
    @GetMapping(path="/add")
	public @ResponseBody String addNewKompanija (@RequestParam Integer kompanija_id, @RequestParam String naziv, @RequestParam Integer adresa_id) {
		
		Company k = new Company();
		k.setId(kompanija_id);
		k.setNaziv(naziv);
		Address a = new Address();
		a.setId(adresa_id);
		a.getId();
		k.setAdresa(a);;
		
		kompanijaRepository.save(k);
		return " Sacuvana Kompanija u bazu ";
		
		
		
	}
    
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Company> getAllKompanija(){
		
		return kompanijaRepository.findAll();
		
	}
	
	 
	 @GetMapping(path="/update")
	 public @ResponseBody String updateKompanija(@RequestParam Integer kompanija_id, 
			 @RequestParam (required = false) String naziv,
			 @RequestParam (required = false) Integer adresa_id ) {
		 
		 Iterable<Company> allKompanija = kompanijaRepository.findAll();
		 
		 for (Company a: allKompanija ) {
			 if (a.getId() == kompanija_id) {
			 if(naziv != null) a.setNaziv(naziv);
			 if(adresa_id != null) {
				 Address adresa = new Address();
				 adresa = adresaRepository.findOne(adresa_id);
				 adresa.setId(adresa_id);
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
