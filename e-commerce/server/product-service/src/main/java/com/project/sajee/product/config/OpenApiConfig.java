package com.project.sajee.product.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI productServiceApi(){
    return new OpenAPI()
            .info(new Info()
                    .title("Product-Service-API")
                    .description("REST API for product microservice")
                    .version("v1.0")
                    .license(new License().name("maven.apache-4.0.0")))
            .externalDocs(new ExternalDocumentation()
                    .description("If you have any concern contact me!")
                    .url("https://sajeevan-profile-web.netlify.app/"));
    }
}
