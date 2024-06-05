package com.alberto.proyectofinal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	Docket createApiRestDoc() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.alberto.proyectofinal"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Registro mascotas API Rest para adopcion")
				.description("Api registro de mascotas para adopcion, para mas informacion, contacte con nostros")
				.termsOfServiceUrl("https://github.com/AlbertoAmnez/proyecto-final.git")
				.contact(new Contact("Alberto Amores Martinez", "https://github.com/AlbertoAmnez/proyecto-final.git",  "albertoamoresmartinez@gmail.com"))
				.build();
	}

}
