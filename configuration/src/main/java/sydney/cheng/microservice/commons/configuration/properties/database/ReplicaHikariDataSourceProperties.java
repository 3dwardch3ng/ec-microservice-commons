package sydney.cheng.microservice.commons.configuration.properties.database;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;

import java.util.Properties;

@Profile(value = {"database"})
@ConfigurationProperties("app.database.replica.hikari")
public class ReplicaHikariDataSourceProperties extends HikariDataSourceProperties {
    public ReplicaHikariDataSourceProperties() {
        super();
    }

    public ReplicaHikariDataSourceProperties(String propertyFileName) {
        super(propertyFileName);
    }

    public ReplicaHikariDataSourceProperties(Properties properties) {
        super(properties);
    }
}
