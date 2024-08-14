package com.clawchat.alpha.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI()
                .info(new Info().title("Alpha API")
                                .description("ClawChat Alpha Project")
                                .version("1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("ClawChat")
                        .url("https://www.clawchat.com/"));
    }

}
