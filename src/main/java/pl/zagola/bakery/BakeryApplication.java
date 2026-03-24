package pl.zagola.bakery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BakeryApplication {

    public static void main(String[] args) {
        //SpringApplication.run(BakeryApplication.class, args);

        //methods of creating objects
        //#1 new
        PersonDetailsRepository personDetailsRepository1 = new PersonDetailsRepositoryListBased(new ArrayList<>());

        //#2 BUILDER
        PersonDetailsRepository personDetailsRepository2 = PersonDetailsRepositoryListBased.builder()
                .personDetailsList(new ArrayList<>())
                .build();

        //#3 static-factory method
        PersonDetailsRepository personDetailsRepository3 = PersonDetailsRepositoryListBased.createInstance();

        //#4 SINGLETON
        PersonDetailsRepository personDetailsRepository4 = PersonDetailsRepositoryListBased.createInstanceSingleton();

        //#5 FACTORY
        PersonDetailsRepository factory = new PersonDetailsRepositoryListBased();
        PersonDetailsRepository personDetailsRepository5 = factory.createRepository();

        //#6 IoC
        ConfigurableApplicationContext context = SpringApplication.run(BakeryApplication.class, args);
        PersonDetailsRepository personDetailsRepository6 = context.getBean(PersonDetailsRepository.class);
        System.out.println(personDetailsRepository6);

        personDetailsRepository2.addPerson(5L, "jan", "kowalski");
        personDetailsRepository2.updatePerson(5L, "nowak");
        List<PersonDetails> all = personDetailsRepository2.findAll();
        System.out.println(all);

        HireDateRepository hireDateRepository = HireDateRepositoryListBased.builder()
                .hireDateList(new ArrayList<>())
                .build();

        hireDateRepository.addHireDate(5L, Instant.now());
        hireDateRepository.addHireDate(1L, Instant.parse("2024-01-01T08:00:00Z"));
        hireDateRepository.addHireDate(2L, Instant.parse("2024-08-01T08:00:00Z"));
        hireDateRepository.addHireDate(3L, Instant.parse("2025-10-01T08:00:00Z"));

        List<HireDate> allHires = hireDateRepository.findAll();
        System.out.println(allHires);

        List<HireDate> newHires = hireDateRepository.findNewHires(365);
        System.out.println(newHires);

        List<HireDate> longTermEmployees1 = hireDateRepository.findLongTermEmployees(5);
        if (longTermEmployees1.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println(longTermEmployees1);
        }
        List<HireDate> longTermEmployees2 = hireDateRepository.findLongTermEmployees(2);
        System.out.println(longTermEmployees2);

        List<HireDate> findByYear = hireDateRepository.findByHireYear(2024);
        System.out.println("hire in 2024: " + findByYear);

//
//        personDetailsRepository.addPerson(1L, "Ola", "Zagrabska");
//        personDetailsRepository.addPerson(2L, "Ania", "Wójcik");
//        personDetailsRepository.addPerson(3L, "Jan", "Nowak");
//        personDetailsRepository.addPerson(4L, "Krzysztof", "Kowalski");
//        personDetailsRepository.addPerson(5L, "Tomasz", "Kowalski");
//        List<PersonDetails> personDetailsRepositoryAll = personDetailsRepository.findAll();
//        System.out.println(personDetailsRepositoryAll);
//
//        List<PersonDetails> personDetailsListFindByLastName = personDetailsRepository.findByLastName("Kowalski");
//        System.out.println(personDetailsListFindByLastName);
//
//        List<PersonDetails> personToUpdate = personDetailsRepository.findById(5L);
//        System.out.println("Przed zmianą: " + personToUpdate);
//
//        boolean updatedPerson = personDetailsRepository.updateLastName(5L, "NowyKowalski");
//        System.out.println("Zaktualizowano: " + updatedPerson);
//        System.out.println("Po: " + personDetailsRepository.findById(5L));
//        System.out.println(personDetailsRepositoryAll);
//
//        boolean deletePerson = personDetailsRepository.deletePerson(1L, "Ola", "Zagrabska");
//        System.out.println("Usunięto: " + deletePerson);
//        System.out.println(personDetailsRepository.findAll());
//
//        HireDateRepository hireRepo = new HireDateRepositoryListBased();
//        boolean hireDateAdd = hireRepo.addHireDate(1L, Instant.now());
//
//        System.out.println("Dodano datę zatrudnienia: " + hireDateAdd);
//        System.out.println(hireRepo.findAll());
//
//        AddressRepository addrRepo = new AddressRepositoryListBased();
//        boolean addrAdd = addrRepo.addAddress(1L, 54.0, 18.0);
//        System.out.println("Dodano nowy adres: " + addrAdd);
//        System.out.println(addrRepo.findAll());

    }

}