package com.rohit.accounts;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
