package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.annotations.mojaAnotacija;
import hello.model.Address;
import hello.model.Company;
import hello.model.Worker;
import hello.service.AddressService;
import hello.service.CompanyService;
import hello.service.WorkerService;

@Controller
@RequestMapping(path="/worker")
public class WorkerController {
	
	
	@Autowired
	private AddressService addressSevice;
    @Autowired
	private CompanyService companyService;
    @Autowired
    private WorkerService workerService;
    
    
    @GetMapping(path="/all")
	public @ResponseBody Iterable<Worker> getAllWorker(){
		
		return workerService.findAll();
		
	}
    
    @GetMapping(path="/all1")
	public @ResponseBody Iterable<Worker> getAllWorkerr(){
		
		throw new RuntimeException("Dummy Exception");
		
	}
  
    @mojaAnotacija
    @GetMapping(path="/add")
  	public @ResponseBody String addNewWorker (@RequestParam Integer id, 
  			@RequestParam String firstName, 
  			@RequestParam String lastName, 
  			@RequestParam Integer age, 
  			@RequestParam Integer address_id, 
  			@RequestParam Integer company_id,
  			@RequestParam String marriage ) {
  		
  		Worker w = new Worker();
  		w.setId(id);
  		w.setFirstName(firstName);
  		w.setLastName(lastName);
  		w.setAge(age);
  		w.setMarriage(marriage);
  		
  		Address a = addressSevice.findById(address_id);
  		w.setAddress(a);
  		
  		Company c = companyService.findById(company_id);  		
  		w.setCompany(c);  	
  		
  		workerService.save(w);
  		return "Saved worker";
  		
 }
    @GetMapping(path="/delete")
    public @ResponseBody String deleteWorker (@RequestParam Integer id ) {
       
    	if(id == null) {
    		return "Wrong id worker";  
    	}    		    
        
        workerService.deleteById(id);
        return "Deleted worker";          
        		 
    }
    
    @GetMapping(path = "/update")
	public @ResponseBody String updateWorker(@RequestParam Integer id,
			@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName,
			@RequestParam(required = false) Integer age,
			@RequestParam(required = false) Integer address_id,
			@RequestParam(required = false) Integer company_id,
			@RequestParam(required = false) String marriage) {
		
		Worker w = workerService.findById(id);
			if(w.getId() == id) {
				if(firstName != null) {
					w.setFirstName(firstName);
				}
				if(lastName != null) {
					w.setLastName(lastName);
				}
				if(age != null) {
					w.setAge(age);
				}
				if(address_id != null) {
					Address a = addressSevice.findById(address_id);
					w.setAddress(a);
				}
				if(company_id != null) {
					Company c = companyService.findById(company_id);
					w.setCompany(c);
				}
				
				workerService.save(w);
				return "Updated worker";
				
			}
		
		return "Wrong id worker";
		
	}   

}
