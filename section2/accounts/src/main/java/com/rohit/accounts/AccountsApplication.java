package com.rohit.accounts;

import com.rohit.accounts.configuration.AccountPerson;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Tag(
		name = "CRUD Rest Apis",
		description = "Learn about crud apis"
)
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Sample Accounts Microservice",
				description = "A simple microservice where u can create account and maintain that",
				contact=@Contact(
						name="ron",
						email = "rohitprashar712@gmail.com"
				)
		)
)
@EnableConfigurationProperties(value = {AccountPerson.class})
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
