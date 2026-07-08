package pl.zagola.bakery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.zagola.bakery.client.repositories.ClientDataRepository;
import pl.zagola.bakery.persondetails.*;

@SpringBootApplication
public class BakeryApplication {

    static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BakeryApplication.class, args);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String bean : beanDefinitionNames) {
            System.out.println(bean);
        }

        ClientDataRepository clientDataRepository = context.getBean(ClientDataRepository.class);
        System.out.println(clientDataRepository);

    }

}