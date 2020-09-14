package cl.global.logic.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "cl.global.logic" })
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ApiGlobalogicApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGlobalogicApplication.class, args);
	}

}
