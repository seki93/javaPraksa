package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.model.Address;
import hello.repository.AddressRepository;

@Controller
@RequestMapping(path="/address")
public class AddressController {

	
	@Autowired
	private AddressRepository addressRepository;
    
    @GetMapping(path="/add")
    public @ResponseBody String addNewAdresa (@RequestParam Integer adresa_id, 
    		@RequestParam String drzava, 
    		@RequestParam String grad, 
			@RequestParam String ulica, 
			@RequestParam Integer broj, 
			@RequestParam Integer sprat) {
		
		Address a = new Address();
		a.setId(adresa_id);
		a.setDrzava(drzava);
		a.setGrad(grad);
		a.setUlica(ulica);
		a.setBroj(broj);
		a.setSprat(sprat);

		addressRepository.save(a);
		return "Saved";
	}
    
    @GetMapping(path="/all")
	public @ResponseBody Iterable<Address> getAllAdresa() {
		
		return addressRepository.findAll();
	}
    
    
    @GetMapping(path="/update")
	 public @ResponseBody String updateAdresa (@RequestParam Integer adresa_id,
	   @RequestParam(required = false) String drzava,
	   @RequestParam(required = false) String grad,
	   @RequestParam(required = false) String ulica,
	   @RequestParam(required = false) Integer broj,
	   @RequestParam(required = false) Integer sprat) {
	  
	  for(Address a: addressRepository.findAll()) {
	   if(a.getId() == adresa_id) {
	    if(drzava != null) a.setDrzava(drzava);
	    if(grad != null) a.setGrad(grad);
	    if(ulica != null) a.setUlica(ulica);
	    if(broj != null) a.setBroj(broj);
	    if(sprat != null) a.setSprat(sprat);
	    
	    addressRepository.save(a);
	    
	    return "Update address";
	   }
	  }
	  
	  return "No address with this id";
	 }
    
    @GetMapping("/delete")
    public @ResponseBody String deleteAdresa (@RequestParam Integer adresa_id ) {
       
    	 if(adresa_id == null) 
             return "Wrong address id";
    	 
    	Address c = new Address();
       
         c.setId(adresa_id);

         
         addressRepository.delete(c);
       return "Delete";
          
        		 
    }
}
