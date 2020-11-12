package mz.co.scntech.srpm.domain.repository;

import mz.co.scntech.srpm.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sidónio Goenha on 11/6/2020
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
}
