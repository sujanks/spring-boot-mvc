package com.siras.service;

import com.siras.dao.PersonDAO;
import com.siras.domain.Person;
import com.siras.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private PersonRepository personRepository;

    public Object findAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        return personRepository.findOne(id);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public void delete(Long id) {
        personRepository.delete(id);
    }
}
