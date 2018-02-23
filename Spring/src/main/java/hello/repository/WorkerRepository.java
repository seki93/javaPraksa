package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.Worker;


	public interface WorkerRepository extends CrudRepository<Worker, Integer> {

		public void deleteById(Integer id);
		
	}

