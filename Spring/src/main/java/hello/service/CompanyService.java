package hello.service;

import hello.model.Company;

public interface CompanyService {
	
	public void deleteById(Integer id);

	public Iterable<Company> findAll();
	
	public void save(Company company);
	
	public Company findById(Integer id);

}
