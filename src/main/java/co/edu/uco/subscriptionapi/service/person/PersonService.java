package co.edu.uco.subscriptionapi.service.person;

import co.edu.uco.subscriptionapi.domain.person.Person;
import co.edu.uco.subscriptionapi.domain.plan.Plan;

import java.util.Map;
import java.util.UUID;

public interface PersonService {

    Person getPersonById(UUID id);
    Person getPersonByName(String name);
    Person getPersonByEmail(String email);
    Person savePerson(Person person);
    Person updatePerson(Person person);
    Person patchPerson(UUID id, Map<?, Object> patchFields);
    void deletePerson(UUID id);

}
