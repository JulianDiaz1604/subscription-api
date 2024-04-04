package co.edu.uco.subscriptionapi.service.person.impl;

import co.edu.uco.subscriptionapi.domain.person.Person;
import co.edu.uco.subscriptionapi.domain.plan.Plan;
import co.edu.uco.subscriptionapi.repository.PersonRepository;
import co.edu.uco.subscriptionapi.repository.entity.PersonEntity;
import co.edu.uco.subscriptionapi.repository.entity.PlanEntity;
import co.edu.uco.subscriptionapi.service.mappers.PersonMapper;
import co.edu.uco.subscriptionapi.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class  PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    private PersonMapper mapper = new PersonMapper();

    @Override
    public Person getPersonById(UUID id) {
        return mapper.toDTO(personRepository.findById(id).get());
    }

    @Override
    public Person getPersonByName(String name) {
        return mapper.toDTO(personRepository.getPersonByName(name));
    }

    @Override
    public Person getPersonByEmail(String email) {
        return mapper.toDTO(personRepository.getPersonByEmail(email));
    }

    @Override
    public Person savePerson(Person person) {
        person.setId(UUID.randomUUID());
        PersonEntity personEntity = mapper.toEntity(person);
        return mapper.toDTO(personRepository.save(personEntity));
    }

    @Override
    public Person updatePerson(Person person) {
        PersonEntity personEntity = mapper.toEntity(person);
        return mapper.toDTO(personRepository.save(personEntity));
    }

    @Override
    public Person patchPerson(UUID id, Map<?, Object> patchFields) {
        Person person = mapper.toDTO(personRepository.findById(id).get());
        if (patchFields.containsKey("name")){
            String value = (String) patchFields.get("name");
            person.setName(value);
        }
        if (patchFields.containsKey("lastName")){
            String value = (String) patchFields.get("lastName");
            person.setLastName(value);
        }
        if (patchFields.containsKey("mobileNumber")){
            String value = (String) patchFields.get("mobileNumber");
            person.setMobileNumber(value);
        }
        if (patchFields.containsKey("documentType")){
            String value = (String) patchFields.get("documentType");
            person.setDocumentType(value);
        }
        if (patchFields.containsKey("identityDocument")){
            String value = (String) patchFields.get("identityDocument");
            person.setIdentityDocument(value);
        }
        if (patchFields.containsKey("email")){
            String value = (String) patchFields.get("email");
            person.setEmail(value);
        }
        PersonEntity personEntity = mapper.toEntity(person);
        return mapper.toDTO(personRepository.save(personEntity));
    }

    @Override
    public void deletePerson(UUID id) {
        personRepository.deleteById(id);
    }

}
