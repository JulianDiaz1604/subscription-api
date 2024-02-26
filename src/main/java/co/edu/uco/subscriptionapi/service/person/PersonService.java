package co.edu.uco.subscriptionapi.service.person;

import co.edu.uco.subscriptionapi.domain.person.Person;

import java.util.UUID;

public interface PersonService {

    Person getPersonById(UUID id);
    Person getPersonByName(String name);
    Person getPersonByEmail(String email);
    Person save(Person person);
    Person updatePerson(Person person);
    void deletePerson(UUID id);

}
