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
	private AddressRepository addressRepository;
    @Autowired
	private CompanyRepository companyRepository;
    
    @Autowired
	private CompanyService companyService;
    
    
    @GetMapping(path="/add")
	public @ResponseBody String addNewCompany (@RequestParam Integer id, 
			@RequestParam String name, 
			@RequestParam Integer address_id) {
		
		Company c = new Company();
		c.setId(id);
		c.setName(name);
		Address a = new Address();
		a.setId(address_id);
		a.getId();
		c.setAddress(a);;
		
		companyRepository.save(c);
		
		return "Saved company";		
		
	}
    
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Company> getAlCompany(){
		
		return companyRepository.findAll();
		
	}
	
	 
	 @GetMapping(path="/update")
	 public @ResponseBody String updateCompany(@RequestParam Integer id, 
			 @RequestParam (required = false) String name,
			 @RequestParam (required = false) Integer adress_id ) {
		 
		 for (Company a: companyRepository.findAll()) {
			 if (a.getId() == id) {
				 if(name != null) {
					 a.setName(name);
				 }
				 if(adress_id != null) {
					 Address adresa = new Address();
					 adresa = addressRepository.findOne(adress_id);
					 adresa.setId(adress_id);
					 a.setAddress(adresa);				 
			 }
			 
			 companyRepository.save(a);			 
			 return " Updated kompanija ";
			 
			 }
		 }
		 return " Wrong id company";
	 }
	 
	 @GetMapping("/delete")
	    public @ResponseBody String deleteKompanija (@RequestParam Integer id ) {
	       
	    	 if(id == null) 
	             return " Ne postoji ta kompanija ";
	    	 
	    	 companyService.deleteById(id);
	    	 
	       return "Obrisano";	          
	        		 
	    }
	
}
