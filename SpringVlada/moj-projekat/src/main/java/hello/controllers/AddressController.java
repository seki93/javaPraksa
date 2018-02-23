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
    
    @GetMapping(path="/all")
	public @ResponseBody Iterable<Address> getAllAddress() {
		
		return addressRepository.findAll();
		
	}
    
    @GetMapping(path="/add")
    public @ResponseBody String addNewAddress (@RequestParam Integer id, 
    		@RequestParam String country, 
    		@RequestParam String city, 
			@RequestParam String street, 
			@RequestParam Integer number, 
			@RequestParam Integer floor) {
		
		Address a = new Address();
		a.setId(id);
		a.setCountry(country);
		a.setCity(city);
		a.setStreet(street);
		a.setNumber(number);
		a.setFloor(floor);

		addressRepository.save(a);
		return "Saved";
	}    
    
    @GetMapping("/delete")
    public @ResponseBody String deleteAddress (@RequestParam Integer id ) {
       
    	 if(id == null) 
             return "Wrong address id";
    	 
    	addressRepository.deleteById(id);         
        return "Delete address";          
        		 
    }
    
    @GetMapping(path="/update")
	 public @ResponseBody String updateAddress (@RequestParam Integer id,
	   @RequestParam(required = false) String country,
	   @RequestParam(required = false) String city,
	   @RequestParam(required = false) String street,
	   @RequestParam(required = false) Integer number,
	   @RequestParam(required = false) Integer floor) {
	  
	  for(Address a: addressRepository.findAll()) {
		  if(a.getId() == id) {
			  if(country != null) {
				  a.setCountry(country);
			  }
			  if(city != null) {
				  a.setCity(city);
			  }
			  if(street != null) {
				  a.setStreet(street);
			  }
			  if(number != null) {
				  a.setNumber(number);
	    
			  }
			  if(floor != null) {
				  a.setFloor(floor);
			  }
	    
			  addressRepository.save(a);	    
			  return "Update address";
		  }
	  }
	  
	  return "No address with this id";
	  
	 }
    
}
