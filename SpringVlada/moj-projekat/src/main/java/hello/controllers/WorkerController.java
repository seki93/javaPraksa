package hello.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.model.Address;
import hello.model.Company;
import hello.model.Worker;
import hello.repository.AddressRepository;
import hello.repository.CompanyRepository;
import hello.repository.WorkerRepository;

@Controller
@RequestMapping(path="/worker")
public class WorkerController {
	
	
	@Autowired
	private AddressRepository addressRepository;
    @Autowired
	private CompanyRepository companyRepository;
    @Autowired
    private WorkerRepository workerRepository;
    
    
    @GetMapping(path="/all")
	public @ResponseBody Iterable<Worker> getAllWorker(){
		
		return workerRepository.findAll();
		
	}
    
   
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
  		
  		Address a = new Address();
  		a.setId(address_id);
  		a.getId();
  		
  		Company c = new Company();
  		c.setId(company_id);
  		c.getId();
  		
  		w.setAddress(a);
  		w.setCompany(c);
  	
  		
  		workerRepository.save(w);
  		return "Saved worker";
  		
 }
    @GetMapping("/delete")
    public @ResponseBody String deleteWorker (@RequestParam Integer id ) {
       
    	if(id == null) 
    		return "Wrong id worker";
    	 
    	Worker r = new Worker();      
        r.setId(id);      
        
       workerRepository.delete(r);
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
		
		for(Worker r: workerRepository.findAll()) {
			if(r.getId() == id) {
				if(firstName != null) {
					r.setFirstName(firstName);
				}
				if(lastName != null) {
					r.setLastName(lastName);
				}
				if(age != null) {
					r.setAge(age);
				}
				if(address_id != null) {
					for(Address a: addressRepository.findAll()) {
						if(a.getId() == address_id) {
							r.setAddress(a);
						}
					}
				}
				if(company_id != null) {
					for(Company k: companyRepository.findAll()) {
						if(k.getId() == company_id) {
							r.setCompany(k);
						}
					}
				}
				return "Updated worker!";
			}
		}
		
		return "Wrong id worker";
		
	}   

}
