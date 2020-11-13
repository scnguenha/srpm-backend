package mz.co.scntech.srpm.controller;

import mz.co.scntech.srpm.domain.model.Stat;
import mz.co.scntech.srpm.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sidónio Goenha on 11/11/2020
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/stats")
public class StatController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public Stat getStats() {
        Stat stat = new Stat();
        stat.setMembers(personRepository.findAll().size());
        return stat;
    }
}
