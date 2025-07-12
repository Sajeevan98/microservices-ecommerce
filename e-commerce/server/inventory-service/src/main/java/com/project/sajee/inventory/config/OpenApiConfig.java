package com.project.sajee.inventory.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI inventoryServiceApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Inventory-Service-API")
                        .description("REST API for inventory microservice")
                        .version("v1.0")
                        .license(new License().name("maven.apache-4.0.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("If you have any concern contact me!")
                        .url("https://sajeevan-profile-web.netlify.app/"));
    }
}
