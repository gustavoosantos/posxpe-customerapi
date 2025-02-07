package br.com.posxp.customerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Customer API",
                version = "v1",
                description = "API for managing customers"
        )
)
public class CustomerapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerapiApplication.class, args);
	}

}
