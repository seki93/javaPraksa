package hello.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.model.Worker;
import hello.repository.WorkerRepository;

@Service
public class WorkerServiceImp implements WorkerService{

	@Autowired
	WorkerRepository workerRepository;
	
	@Override
	@Transactional
	public void deleteById(Integer id) {

		workerRepository.deleteById(id);
		
	}

	@Override
	public Iterable<Worker> findAll() {
		
		Iterable<Worker> workers = workerRepository.findAll();
		
		if(workers != null) {
			return workers;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public void save(Worker w) {
		
		workerRepository.save(w);
		
	}

	public Worker findById(Integer id) {

		Worker w = workerRepository.findOne(id);
		
		if(w != null) {
			return w;
		} else {
			return null;
		}
		
	}
	
}
