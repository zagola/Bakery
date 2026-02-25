package pl.zagola.bakery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BakeryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BakeryApplication.class, args);
	}

}
