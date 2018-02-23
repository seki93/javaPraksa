package hello.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import hello.repository.WorkerRepository;

public class WorkerServiceImp implements WorkerService{

	@Autowired
	WorkerRepository workerRepository;
	
	@Override
	@Transactional
	public void deleteById(Integer id) {

		workerRepository.deleteById(id);
		
	}
	
}
