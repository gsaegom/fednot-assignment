package be.fednot.testguillermo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@Configuration
public class SwaggerConfig {
    //TODO: Use builder to remove innecessary info
    //TODO: Find a way to clean up requests

    private ApiInfo apiInfo() {
        return new ApiInfo("Fednot evaluation",
                "API documentation for the assignment given by Fednot",
                "1.0",
                "Terms of service",
                new Contact("Guillermo Sáez Gómez", "www.github.com/gsaegom", "guillermosaezgomez@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}