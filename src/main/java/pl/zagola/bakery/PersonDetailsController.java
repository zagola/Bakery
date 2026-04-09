package pl.zagola.bakery;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonDetailsController {
    private final PersonDetailsRepository personDetailsRepository;

    public PersonDetailsController(PersonDetailsRepository personDetailsRepository) {
        this.personDetailsRepository = personDetailsRepository;
    }

    @GetMapping(path = "/persondetails")
    public ResponseEntity<List<PersonDetails>> getPersonDetails() {
        List<PersonDetails> personDetails = personDetailsRepository.findAll();
        return ResponseEntity.ok(personDetails);
    }
}