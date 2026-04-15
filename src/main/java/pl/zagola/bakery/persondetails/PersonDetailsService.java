package pl.zagola.bakery.persondetails;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDetailsService {
    private final PersonDetailsRepository personDetailsRepository;

    public PersonDetailsService(PersonDetailsRepository personDetailsRepository) {
        this.personDetailsRepository = personDetailsRepository;
    }

    public List<PersonDetails> getPersonDetails() {
        return personDetailsRepository.findAll();
    }

    public boolean addPersonDetails(PersonDetails personDetails) {
        return personDetailsRepository.addPerson(personDetails);
    }
}