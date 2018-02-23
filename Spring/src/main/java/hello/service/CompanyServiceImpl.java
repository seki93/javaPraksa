package hello.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.Company;
import hello.repository.CompanyRepository;


@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Override
	@Transactional
	public void deleteById(Integer id) {
		companyRepository.deleteById(id);
	}

	@Override
	public Iterable<Company> findAll() {
		
		Iterable<Company> c = companyRepository.findAll();
		
		if(c != null) {
			return c;
		} else {
			return c;
		}
	}

	@Override
	@Transactional
	public void save(Company company) {
		
		companyRepository.save(company);
		
	}

	@Override
	public Company findById(Integer id) {

		Company c = companyRepository.findOne(id);
		
		if(c != null) {
			return c;
		} else {
			return null;
		}
		
	}	

}
