package co.edu.uco.subscriptionapi.controller.person;

import co.edu.uco.subscriptionapi.domain.person.Person;
import co.edu.uco.subscriptionapi.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rest")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public Person getPersonById(@RequestParam UUID id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/person")
    public Person getPersonByName(@RequestParam String name) {
        return personService.getPersonByName(name);
    }

    @GetMapping("/person")
    public Person getPersonByEmail(@RequestParam String name) {
        return personService.getPersonByName(name);
    }

    @PostMapping("/person")
    public Person savePerson(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping("/person")
    public Person updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @DeleteMapping("/person")
    public void deletePerson(@RequestParam UUID id) {
        personService.deletePerson(id);
    }

}
