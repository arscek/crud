package org.itq.crud.controller;

import org.itq.crud.entity.Person;
import org.itq.crud.org.itq.crud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by a212359654 on 9/7/17.
 */

@RestController
@RequestMapping("crud/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createPerson(@RequestBody Person p){
        personService.savePerson(p);
    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.PUT)
    public void updatePerson(@PathVariable long personId, @RequestBody Person p){
        Person person = personService.getPerson(personId);
        if(person == null){
            throw new ResourceNotFoundException("Person not found");
        }

        person.setFirstName(p.getFirstName());
        person.setLastName(p.getLastName());

        personService.savePerson(person);

    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.DELETE)
    public void deletePerson(@PathVariable long personId){
        Person person = personService.getPerson(personId);
        if(person == null){
            throw new ResourceNotFoundException("Person not found");
        }

        personService.deletePerson(person);
    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable long personId){
        return personService.getPerson(personId);
    }
}
