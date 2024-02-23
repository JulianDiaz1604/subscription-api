package co.edu.uco.subscriptionapi.service.person.impl;

import co.edu.uco.subscriptionapi.domain.person.Person;
import co.edu.uco.subscriptionapi.service.person.PersonService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public Person getPersonById(UUID id) {
        return new Person();
    }

    @Override
    public Person getPersonByName(String name) {
        return new Person();
    }

    @Override
    public Person getPersonByEmail(String email) {
        return new Person();
    }

    @Override
    public Person save(Person person) {
        return new Person();
    }

    @Override
    public Person updatePerson(Person person) {
        return new Person();
    }

    @Override
    public void deletePerson(UUID id) {

    }

}
