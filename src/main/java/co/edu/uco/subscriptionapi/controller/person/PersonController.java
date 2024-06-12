package co.edu.uco.subscriptionapi.controller.person;

import co.edu.uco.subscriptionapi.domain.person.Person;
import co.edu.uco.subscriptionapi.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/rest")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public ResponseEntity<?> getPersonById(@RequestParam UUID id) {
        try {
            Person person = personService.getPersonById(id);
            if (person != null) {
                return ResponseEntity.ok(person);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving person: " + e.getMessage());
        }
    }

    @GetMapping("/person/name/{name}")
    public ResponseEntity<?> getPersonByName(@PathVariable("name") String name) {
        try {
            Person person = personService.getPersonByName(name);
            if (person != null) {
                return ResponseEntity.ok(person);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving person: " + e.getMessage());
        }
    }

    @GetMapping("/person/email/{email}")
    public ResponseEntity<?> getPersonByEmail(@PathVariable String email) {
        try {
            Person person = personService.getPersonByEmail(email);
            if (person != null) {
                return ResponseEntity.ok(person);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving person: " + e.getMessage());
        }
    }

    @PostMapping("/person")
    public ResponseEntity<?> savePerson(@RequestBody Person person) {
        try {
            Person savedPerson = personService.savePerson(person);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving person: " + e.getMessage());
        }
    }

    @PutMapping("/person")
    public ResponseEntity<?> updatePerson(@RequestBody Person person) {
        try {
            Person updatedPerson = personService.updatePerson(person);
            if (updatedPerson != null) {
                return ResponseEntity.ok(updatedPerson);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating person: " + e.getMessage());
        }
    }

    @DeleteMapping("/person")
    public ResponseEntity<?> deletePerson(@RequestParam UUID id) {
        try {
            personService.deletePerson(id);
            return ResponseEntity.ok().body("Person deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting person: " + e.getMessage());
        }
    }

    @PatchMapping("/person")
    public ResponseEntity<?> patchPerson(@RequestBody Map<String, Object> patchFields, @RequestParam UUID id) {
        try {
            Person patchedPerson = personService.patchPerson(id, patchFields);
            if (patchedPerson != null) {
                return ResponseEntity.ok(patchedPerson);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error patching person: " + e.getMessage());
        }
    }

}
