package com.services.impl;

import entities.Person;
import exceptions.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.SpringDataPersonRepo;
import services.IPersonService;

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