package com.clawchat.alpha.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "swagger")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SwaggerProperties {

    private String title;

    private String description;

    private String version;

    private String author;

    private String url;

    private String email;

}
