package sydney.cheng.microservice.commons.configuration.properties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import sydney.cheng.microservice.commons.configuration.properties.auth.SecurityProperties;
import sydney.cheng.microservice.commons.configuration.properties.database.DatabaseProperties;

@Data
@ConfigurationPropertiesScan(basePackages = {"sydney.cheng.**.properties"})
@ConfigurationProperties("app")
@Configuration
public class AppConfiguration {
    private ApplicationConfiguration application;
    private SecurityProperties security;
    private DatabaseProperties database;

    @Data
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ApplicationConfiguration {
        private String deploymentTarget;
    }
}
