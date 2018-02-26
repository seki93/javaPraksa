package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import hello.model.Address;
import hello.model.Company;
import hello.service.AddressService;
import hello.service.CompanyService;

@Controller
@RequestMapping(path="/company")
public class CompanyController {

	@Autowired
	private AddressService addressService;
    @Autowired
	private CompanyService companyService;
        
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Company> getAllCompany(){
		
		return companyService.findAll();
		
	}
    
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
		
		companyService.save(c);
		
		return "Saved company";		
		
	}	
	 
	 @GetMapping(path="/delete")
	 public @ResponseBody String deleteCompany (@RequestParam Integer id ) {
	       
	    	 if(id == null) 
	             return "Wrong id company";
	    	 
	    	 companyService.deleteById(id);	    	 
	    	 return "Deleted company";	          
	        		 
	 }
	 
	 @GetMapping(path="/update")
	 public @ResponseBody String updateCompany(@RequestParam Integer id, 
			 @RequestParam (required = false) String name,
			 @RequestParam (required = false) Integer address_id ) {
		 
		 Company c = companyService.findById(id);
		 if (c.getId() == id) {
			 if(name != null) {
				 c.setName(name);
			 }
			 if(address_id != null) {
				 Address address = new Address();
				 address = addressService.findById(address_id);
				 c.setAddress(address);				 
			 }
			 
		 companyService.save(c);			 
		 return "Updated company";
			 
		}
		 
		return "Wrong id company";
		 
	 }
	
}
