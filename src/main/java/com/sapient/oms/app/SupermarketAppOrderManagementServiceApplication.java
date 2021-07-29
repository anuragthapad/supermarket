package com.sapient.oms.app;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication(scanBasePackages = "com.sapient")
//@EntityScan(basePackages = "com.sapient.cms.entity")
@EnableOpenApi
public class SupermarketAppOrderManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupermarketAppOrderManagementServiceApplication.class, args);
	}

	@Bean
	public Docket openApiPetStore() {
		return new Docket(DocumentationType.OAS_30)
				.groupName("open-api-order-management-service")
				.select()
				.paths(cmsPaths())
				.build();
	}

	private Predicate<String> cmsPaths() {
		return regex(".*/om/.*");
	}
}
