package com.app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Staff Management Microservice API", version = "1.0", description = "API is used for managing staff members and their assignments to give services in the Online Salon Service", contact = @Contact(name = "Swathi Kalluri", email = "swathi123@gmail.com", url = "pqr")))
public class StaffManagementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffManagementMicroserviceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
