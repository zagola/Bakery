package pl.zagola.bakery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

import java.time.Instant;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BakeryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BakeryApplication.class, args);

        PersonDetailsRepository personDetailsRepository = new PersonDetailsRepositoryListBased();
        personDetailsRepository.addPerson(1L, "Ola", "Zagrabska");
        personDetailsRepository.addPerson(2L, "Ania", "Wójcik");
        personDetailsRepository.addPerson(3L, "Jan", "Nowak");
        personDetailsRepository.addPerson(4L, "Krzysztof", "Kowalski");
        personDetailsRepository.addPerson(5L, "Tomasz", "Kowalski");
        List<PersonDetails> personDetailsRepositoryAll = personDetailsRepository.findAll();
        System.out.println(personDetailsRepositoryAll);

        List<PersonDetails> personDetailsListFindByLastName = personDetailsRepository.findByLastName("Kowalski");
        System.out.println(personDetailsListFindByLastName);

        List<PersonDetails> personToUpdate = personDetailsRepository.findById(5L);
        System.out.println("Przed zmianą: " + personToUpdate);

        boolean updatedPerson = personDetailsRepository.updateLastName(5L, "NowyKowalski");
        System.out.println("Zaktualizowano: " + updatedPerson);
        System.out.println("Po: " + personDetailsRepository.findById(5L));
        System.out.println(personDetailsRepositoryAll);

        boolean deletePerson = personDetailsRepository.deletePerson(1L, "Ola", "Zagrabska");
        System.out.println("Usunięto: " + deletePerson);
        System.out.println(personDetailsRepository.findAll());

        HireDateRepository hireRepo = new HireDateRepositoryListBased();
        boolean hireDateAdd = hireRepo.addHireDate(1L, Instant.now());

        System.out.println("Dodano datę zatrudnienia: " + hireDateAdd);
        System.out.println(hireRepo.findAll());

        AddressRepository addrRepo = new AddressRepositoryListBased();
        boolean addrAdd = addrRepo.addAddress(1L, 54.0, 18.0);
        System.out.println("Dodano nowy adres: " + addrAdd);
        System.out.println(addrRepo.findAll());

    }

}