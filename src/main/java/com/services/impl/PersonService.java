package com.services.impl;

import com.entities.Person;
import com.exceptions.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import com.repo.SpringDataPersonRepo;
import com.services.IPersonService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonService implements IPersonService {

    @Autowired
    private SpringDataPersonRepo personRepo;

    @Override
    public Optional<Person> findById(Long id) {
        return personRepo.findById(id);
    }

    @Override
    public Person addPerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    @Secured("ROLE_ADMIN")//@RolesAllowed("ROLE_ADMIN")
    //Used to restrict the domain that a user is allowed to affect with its actions.
    //Spring does this by using Spring ACL (Access Control List) classes
    @PreAuthorize("#user.username == authentication.name")//@PreAuthorize,@PreFilter, @PostAuthorize and @PostFilter
    public List<Person> findAll() {
        return personRepo.findAll();
    }

    @Override
    public int countAllPerson() {
        return findAll().size();
    }
}
