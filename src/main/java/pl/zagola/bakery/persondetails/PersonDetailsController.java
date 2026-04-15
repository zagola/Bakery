package pl.zagola.bakery.persondetails;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonDetailsController {
    private final PersonDetailsService personDetailsService;

    public PersonDetailsController(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @GetMapping(path = "/persondetails")
    public ResponseEntity<List<PersonDetails>> getPersonDetails() {
        List<PersonDetails> personDetails = personDetailsService.getPersonDetails();
        return ResponseEntity.ok(personDetails);
    }

    @PostMapping(path = "/persondetails")
    public ResponseEntity<PersonDetails> createPersonDetails(@RequestBody PersonDetails personDetails) {
        boolean saved = personDetailsService.addPersonDetails(personDetails);
        if (saved) {
            return ResponseEntity.ok(personDetails);
        }
        return ResponseEntity.notFound().build();
    }
}