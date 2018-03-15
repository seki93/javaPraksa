package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import hello.model.Sportsman;

public interface SportsmanCriteriaRepository  extends JpaRepository<Sportsman, Long>, JpaSpecificationExecutor<Sportsman> {
	
}