package pl.zagola.bakery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import pl.zagola.bakery.address.Address;
import pl.zagola.bakery.address.AddressRepository;
import pl.zagola.bakery.address.AddressRepositoryListBased;
import pl.zagola.bakery.client.Client;
import pl.zagola.bakery.client.ClientRepository;
import pl.zagola.bakery.client.ClientRepositoryListBased;
import pl.zagola.bakery.employee.Employee;
import pl.zagola.bakery.employee.EmployeeRepository;
import pl.zagola.bakery.employee.EmployeeRepositoryListBased;
import pl.zagola.bakery.hiredate.HireDate;
import pl.zagola.bakery.hiredate.HireDateRepository;
import pl.zagola.bakery.hiredate.HireDateRepositoryListBased;
import pl.zagola.bakery.owner.Owner;
import pl.zagola.bakery.owner.OwnerRepository;
import pl.zagola.bakery.owner.OwnerRepositoryListBased;
import pl.zagola.bakery.persondetails.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        PersonDetailsRepositoryFactory personDetailsRepositoryFactory = new PersonDetailsRepositoryFactoryImpl();
        PersonDetailsRepository personDetailRepository5 = personDetailsRepositoryFactory.createPersonDetails();


        //#6 IoC
        ConfigurableApplicationContext context = SpringApplication.run(BakeryApplication.class, args);
        PersonDetailsRepository personDetailsRepository6 = context.getBean(PersonDetailsRepository.class);
        System.out.println(personDetailsRepository6);

        //factory

        boolean addPerson3 = personDetailRepository5.addPerson(new PersonDetails(15L, "kamil", "łajka"));
        boolean addPerson4 = personDetailRepository5.addPerson(new PersonDetails(16L, "michał", "koper"));
        System.out.println("add person with factory pattern: " + addPerson3);
        System.out.println("add person with factory pattern: " + addPerson4);
        List<PersonDetails> factoryListPerson = personDetailRepository5.findAll();
        System.out.println("factoryListPerson: " + factoryListPerson);
        Optional<PersonDetails> findByIdFactory = personDetailRepository5.findById(15L);
        System.out.println("findByIdFactory: " + findByIdFactory);

        //builder
        boolean addPerson1 = personDetailsRepository2.addPerson(new PersonDetails(3L, "jan", "kowalski"));
        boolean addPerson2 = personDetailsRepository2.addPerson(new PersonDetails(4L, "jadwiga", "mazur"));
        System.out.println("add person " + addPerson1);
        System.out.println("add person " + addPerson2);
        List<PersonDetails> all = personDetailsRepository2.findAll();
        System.out.println(all);
        boolean updatePerson = personDetailsRepository2.updatePerson(new PersonDetails(3L, "jarek", "kowalski"));
        System.out.println("update person " + updatePerson);
        List<PersonDetails> allPerson = personDetailsRepository2.findAll();
        System.out.println(allPerson);
        List<PersonDetails> kowalski = personDetailsRepository2.findByLastName("kowalski");
        System.out.println("findByLastName " + kowalski);
        Optional<PersonDetails> findById = personDetailsRepository2.findById(4L);
        System.out.println("findById " + findById);
        boolean b = personDetailsRepository2.deletePerson(3L);
        System.out.println("delete person " + b);
        List<PersonDetails> updateList = personDetailsRepository2.findAll();
        System.out.println(updateList);

        HireDateRepository hireDateRepository = HireDateRepositoryListBased.builder()
                .hireDateList(new ArrayList<>())
                .build();

        hireDateRepository.addHireDate(5L, Instant.now());
        hireDateRepository.addHireDate(1L, Instant.parse("2024-01-01T08:00:00Z"));
        hireDateRepository.addHireDate(2L, Instant.parse("2024-08-01T08:00:00Z"));
        hireDateRepository.addHireDate(3L, Instant.parse("2025-10-01T08:00:00Z"));

        List<HireDate> allHires = hireDateRepository.findAll();
        System.out.println("all hires: " + allHires);

        List<HireDate> newHires = hireDateRepository.findNewHires(365);
        System.out.println("find new hires: " + newHires);

        List<HireDate> longTermEmployees1 = hireDateRepository.findLongTermEmployees(5);
        if (longTermEmployees1.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("employees hired 5 years ago" + longTermEmployees1);
        }
        List<HireDate> longTermEmployees2 = hireDateRepository.findLongTermEmployees(2);
        System.out.println("employees hired 2 years ago " + longTermEmployees2);

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

        EmployeeRepository employeeRepository = EmployeeRepositoryListBased.builder()
                .employeeList(new ArrayList<>())
                .build();

        boolean addE1 = employeeRepository.addEmployee(new PersonDetails(6L, "Olaf", "Nowak"), Instant.parse("2023-05-01T08:00:00Z"));
        System.out.println("Add new employee: " + addE1);
        boolean addE2 = employeeRepository.addEmployee(new PersonDetails(7L, "Jan", "Mazur"), Instant.parse("2023-06-01T08:00:00Z"));
        System.out.println("Add new employee: " + addE2);
        List<Employee> newEmployees = employeeRepository.findAll();
        System.out.println(newEmployees);

        Optional<Employee> find = employeeRepository.findByPersonId(7L);
        System.out.println(find);

        boolean updateEmp = employeeRepository.updateEmployee(new PersonDetails(8L, "Jan", "Mazurek"), Instant.parse("2023-06-01T08:00:00Z"));
        System.out.println("Update employee: " + updateEmp);
        System.out.println(employeeRepository.findAll());

        boolean deleteEmp = employeeRepository.deleteEmployee(7L);
        System.out.println("Delete employee: " + deleteEmp);

        boolean deleteEmp2 = employeeRepository.deleteEmployee(6L);
        System.out.println("Delete employee: " + deleteEmp2);
        List<Employee> allEmployees = employeeRepository.findAll();
        System.out.println(allEmployees);

        ClientRepository clientRepository = ClientRepositoryListBased.builder()
                .clientList(new ArrayList<>())
                .build();

        boolean addCli1 = clientRepository.addClient(new PersonDetails(10L, "Anna", "Zawadzka"), new Address(10L, 52.0, 18.0));
        System.out.println("Add new client: " + addCli1);
        boolean addCli2 = clientRepository.addClient(new PersonDetails(11L, "Piotr", "Kowalski"), new Address(11L, 51.0, 21.0));
        System.out.println("Add new client: " + addCli2);
        List<Client> allClients = clientRepository.findAll();
        System.out.println(allClients);

        Optional<Client> findCli1 = clientRepository.findByPersonId(11L);
        System.out.println(findCli1);
        Optional<Client> findCli2 = clientRepository.findByPersonId(2L);
        System.out.println(findCli2);

        boolean updateCli = clientRepository.updateClient(new PersonDetails(10L, "Anna", "Kowalska"), new Address(10L, 52.0, 18.0));
        System.out.println("Update client: " + updateCli);
        List<Client> findAll = clientRepository.findAll();
        System.out.println(findAll);

        boolean cli1 = clientRepository.deleteClient(1L);
        System.out.println("Delete client: " + cli1);
        boolean cli11 = clientRepository.deleteClient(11L);
        System.out.println("Delete client: " + cli11);
        List<Client> allClients1 = clientRepository.findAll();
        System.out.println(allClients1);

        OwnerRepository ownerRepository = OwnerRepositoryListBased.builder()
                .ownerList(new ArrayList<>())
                .build();

        boolean adDOwner = ownerRepository.addOwner(new PersonDetails(1L, "Jan", "Właściciel"), new Address(1L, 52.0, 21.0), new HireDate(1L, Instant.parse("2020-06-01T08:00:00Z")));
        System.out.println("Add owner: " + adDOwner);

        List<Owner> owner = ownerRepository.findOwner();
        System.out.println(owner);

        Optional<Owner> byId = ownerRepository.findById(1L);
        System.out.println(byId);

        boolean newOwner = ownerRepository.updateOwner(new PersonDetails(1L, "Tomasz", "NowyWłaściciel"), new Address(1L, 52.0, 21.0), new HireDate(1L, Instant.parse("2026-04-01T08:00:00Z")));
        System.out.println("Update owner: " + newOwner);
        System.out.println("Update owner: " + ownerRepository.findById(1L));

        boolean deleteOwner = ownerRepository.deleteOwner(1L);
        System.out.println("Delete owner: " + deleteOwner);
        System.out.println("Where is the owner? " + ownerRepository.findById(1L));


    }

}