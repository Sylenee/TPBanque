package isen.group1.api.assurance.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.GroupedOpenApi;

@Configuration
public class SpringdocOpenApiConfig {

    @Bean
    public GroupedOpenApi assuranceOpenApi() {
        return GroupedOpenApi.builder()
                .group("assurance")
                .pathsToMatch("/clients/**", "/conseiller/**","/test-logs")
                .build();
    }
}
