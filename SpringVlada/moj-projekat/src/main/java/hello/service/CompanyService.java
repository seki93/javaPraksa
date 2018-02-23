package hello.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

public interface CompanyService {
	
	public void deleteById(Integer id);

}
