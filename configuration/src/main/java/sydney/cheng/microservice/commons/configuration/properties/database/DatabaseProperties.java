package sydney.cheng.microservice.commons.configuration.properties.database;

import lombok.Data;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;

@Profile("database")
@Data
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "app.database")
public class DatabaseProperties {
    EntityManagerProperties entityManager;
    JpaProperties jpa;
    DatabaseNodeProperties primary;
    DatabaseNodeProperties replica;

    @Data
    public static class EntityManagerProperties implements Serializable {
        String packages;
    }
}
