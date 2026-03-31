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

    static void main(String[] args) {
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
        System.out.println("hired in 2024: " + findByYear);

        List<HireDate> findHireDateBetween = hireDateRepository.findHireDateBetween(Instant.parse("2024-01-01T08:00:00Z"), Instant.now());
        System.out.println("hired since 2024: " + findHireDateBetween);

        boolean updateHireDate = hireDateRepository.updateHireDate(1L, Instant.parse("2026-01-01T08:00:00Z"));
        System.out.println("update hire date: " + updateHireDate);
        System.out.println(hireDateRepository.findAll());

        AddressRepository addressRepository = AddressRepositoryListBased.builder()
                .addressList(new ArrayList<>())
                .build();

        addressRepository.addAddress(1L, 52, 21);
        addressRepository.addAddress(2L, 51, 17);

        List<Address> allAddresses = addressRepository.findAll();
        System.out.println(allAddresses);

        List<Address> findAddress = addressRepository.findByPersonId(2L);
        System.out.println(findAddress);

        boolean updateAddress = addressRepository.updateAddress(1L, 53, 23);
        System.out.println("update address: " + updateAddress);
        System.out.println(addressRepository.findAll());

        boolean deleteAddress = addressRepository.deleteAddress(2L);
        System.out.println("delete address: " + deleteAddress);
        System.out.println(addressRepository.findAll());

    }

}