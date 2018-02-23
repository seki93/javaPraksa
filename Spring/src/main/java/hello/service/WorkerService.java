package hello.service;

import hello.model.Worker;

public interface WorkerService {

	public void deleteById(Integer id);

	public Iterable<Worker> findAll();

	public void save(Worker w);

	public Worker findById(Integer id);
	
}
