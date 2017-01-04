package com.siras.service;

import com.siras.domain.Person;


public interface PersonService {

    public Object findAll();

    public Person findById(Long id);

    public Person save(Person person);

    public void delete(Long id);
}
