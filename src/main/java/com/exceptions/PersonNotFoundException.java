package com.exceptions;

import com.entities.Person;

public class PersonNotFoundException extends NotFoundException{

    public PersonNotFoundException(Long id){
        super(Person.class, id);
    }
}
