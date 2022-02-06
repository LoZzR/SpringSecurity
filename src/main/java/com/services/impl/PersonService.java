package com.services.impl;

import com.entities.Person;
import com.exceptions.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repo.SpringDataPersonRepo;
import com.services.IPersonService;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private SpringDataPersonRepo personRepo;

    @Override
    public Person findById(Long id) {
        return personRepo.findById(id).orElse(new Person());
    }

    @Override
    public Person addPerson(Person person) {
        return personRepo.save(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepo.findAll();
    }

    @Override
    public int countAllPerson() {
        return findAll().size();
    }
}
