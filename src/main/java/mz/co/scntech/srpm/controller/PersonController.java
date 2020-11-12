package mz.co.scntech.srpm.controller;

import mz.co.scntech.srpm.domain.model.Person;
import mz.co.scntech.srpm.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sidónio Goenha on 11/6/2020
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/{personId}")
    public Person findPersonById(@PathVariable Long personId) {
        return personRepository.findById(personId).orElse(null);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person addPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PostMapping("/many")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Person> addPersons(@RequestBody List<Person> persons) {
        return personRepository.saveAll(persons);
    }

    @PutMapping("/{personId}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long personId, @RequestBody Person person) {
        if (!personRepository.existsById(personId)) {
            return ResponseEntity.notFound().build();
        }
        person.setId(personId);

        return ResponseEntity.ok(personRepository.save(person));
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<Person> deletePerson(@PathVariable Long personId) {
        if (!personRepository.existsById(personId)) {
            return ResponseEntity.notFound().build();
        }
        personRepository.deleteById(personId);
        return ResponseEntity.noContent().build();
    }
}
