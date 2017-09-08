package org.itq.crud.org.itq.crud.service;

import org.itq.crud.entity.Person;
import org.itq.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by a212359654 on 9/7/17.
 */

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public Iterable<Person> getAllPersons(){
        return personRepository.findAll();
    }

    public void savePerson(Person p){
        personRepository.save(p);
    }

    public void deletePerson(Person p){
        personRepository.delete(p);
    }

    public Person getPerson(long id){
        return personRepository.findOne(id);
    }
}
