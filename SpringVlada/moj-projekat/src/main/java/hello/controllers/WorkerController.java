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
  	public @ResponseBody String addNewWorker (@RequestParam Integer jmbg, 
  			@RequestParam String ime, 
  			@RequestParam String prezime, 
  			@RequestParam Integer godine, 
  			@RequestParam Integer adresa_id, 
  			@RequestParam Integer kompanija_id,
  			@RequestParam String bracniStatus ) {
  		
  		Worker r = new Worker();

  		r.setId(jmbg);
  		r.setIme(ime);
  		r.setPrezime(prezime);
  		r.setGodine(godine);
  		r.setBracniStatus(bracniStatus);
  		
  		Address a = new Address();
  		a.setId(adresa_id);
  		a.getId();
  		
  		Company k = new Company();
  		k.setId(kompanija_id);
  		k.getId();
  		
  		r.setAdresa(a);
  		r.setKompanija(k);
  	
  		
  		workerRepository.save(r);
  		return "Saved";
 }
    @GetMapping("/delete")
    public @ResponseBody String deleteWorker (@RequestParam Integer jmbg ) {
       
    	 if(jmbg == null) 
             return "Wrong id worker";
    	 
    	Worker r = new Worker();
       
        r.setId(jmbg);
        

         
         workerRepository.delete(r);
       return "Deleted";
          
        		 
    }
    
    @GetMapping(path = "/update")
	public @ResponseBody String updateWorker(@RequestParam Integer jmbg,
			@RequestParam(required = false) String ime,
			@RequestParam(required = false) String prezime,
			@RequestParam(required = false) Integer godine,
			@RequestParam(required = false) Integer adresa_id,
			@RequestParam(required = false) Integer kompanija_id,
			@RequestParam(required = false) String bracni_status) {
		
		for(Worker r: workerRepository.findAll()) {
			if(r.getId() == jmbg) {
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
					for(Address a: addressRepository.findAll()) {
						if(a.getId() == adresa_id) {
							r.setAdresa(a);
						}
					}
				}
				if(kompanija_id != null) {
					for(Company k: companyRepository.findAll()) {
						if(k.getId() == kompanija_id) {
							r.setKompanija(k);
						}
					}
				}
				return "Updated worker!";
			}
		}
		
		return "Wrong id worker";
		
	}
    
    
    
    

}
