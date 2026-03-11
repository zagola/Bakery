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
        PersonDetails detailsEmployeeJan = new PersonDetails("Jan", "Zieliński");
        Employee jan = new Employee(detailsEmployeeJan, Instant.now());

        PersonDetails detailsClientKarol = new PersonDetails("Karol", "Nowak");
        Client karol = new Client(detailsClientKarol, new GeographicAddress(30.0, 24.5), 1);

        PersonDetailsRepository personDetailsRepository = new PersonDetailsRepositoryListBased();
        personDetailsRepository.addPerson("Ola", "Zagrabska");
        List<PersonDetails> personDetailsRepositoryAll = personDetailsRepository.findAll();
        System.out.println(personDetailsRepositoryAll);


    }

}