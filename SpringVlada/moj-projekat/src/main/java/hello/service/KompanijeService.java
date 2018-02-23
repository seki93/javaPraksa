package hello.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

public interface KompanijeService {
	
	public void deleteById(Integer id);

}
