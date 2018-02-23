package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.Company;


public interface CompanyRepository extends CrudRepository<Company, Integer> {
	
	public void deleteById(Integer id);
	
}