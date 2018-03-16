package hello.controllers;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.model.Address;
import hello.service.AddressService;

@Controller
@RequestMapping(path="/address")
public class AddressController {

	
	@Autowired
	private AddressService addressService;
    
    @GetMapping(path="/all")
	public @ResponseBody Iterable<Address> getAllAddress() {

		Iterable<Address> addresses = addressService.findAll();
    	
    	if(addresses != null) {
    		return addresses;
    	}else {
			return null;
		}
		
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

		addressService.save(a);
		return "Saved address";
	}    
    
    @GetMapping(path="/delete")
    public @ResponseBody String deleteAddress (@RequestParam Integer id ) {
       
    	 if(id == null) 
             return "Wrong address id";
    	 
    	addressService.deleteById(id);         
        return "Delete address";          
        		 
    }
    
    @GetMapping(path="/update")
	 public @ResponseBody String updateAddress (@RequestParam Integer id,
	   @RequestParam(required = false) String country,
	   @RequestParam(required = false) String city,
	   @RequestParam(required = false) String street,
	   @RequestParam(required = false) Integer number,
	   @RequestParam(required = false) Integer floor) {
	 
    	Address a = addressService.findById(id);
		  if(a != null) {
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
	    
			  addressService.save(a);	    
			  return "Update address";
		  }
	  
	  return "No address with this id";
	  
	 }
    
}
