package co.edu.uco.subscriptionapi.service.mappers;

import co.edu.uco.subscriptionapi.domain.person.Person;
import co.edu.uco.subscriptionapi.repository.entity.PersonEntity;

public class PersonMapper {

    public Person toDTO(PersonEntity personEntity) {

        Person personDTO = new Person();
        personDTO.setId(personEntity.getId());
        personDTO.setName(personEntity.getName());
        personDTO.setLastName(personEntity.getLastName());
        personDTO.setMobileNumber(personEntity.getLastName());
        personDTO.setDocumentType(personEntity.getDocumentType());
        personDTO.setIdentityDocument(personEntity.getIdentityDocument());
        personDTO.setEmail(personEntity.getEmail());
        return personDTO;

    }

    public PersonEntity toEntity(Person personDTO) {

        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(personDTO.getId());
        personEntity.setName(personDTO.getName());
        personEntity.setLastName(personDTO.getLastName());
        personEntity.setMobileNumber(personDTO.getLastName());
        personEntity.setDocumentType(personDTO.getDocumentType());
        personEntity.setIdentityDocument(personDTO.getIdentityDocument());
        personEntity.setEmail(personDTO.getEmail());
        return personEntity;

    }

}
