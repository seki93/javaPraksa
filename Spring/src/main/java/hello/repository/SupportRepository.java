package hello.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hello.model.Support;
import hello.model.SupportCompositeKey;

@Repository
public interface SupportRepository extends CrudRepository<Support, SupportCompositeKey> {

}
