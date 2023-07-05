package com.cg.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SmartContactManager1Application {

	public static void main(String[] args) {
		SpringApplication.run(SmartContactManager1Application.class, args);
		System.out.println("Running Successfully");
	}
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
        		.apis(RequestHandlerSelectors.basePackage("com.cg.contact")).build();
    }

}
