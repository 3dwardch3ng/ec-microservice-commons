package sydney.cheng.microservice.commons.configuration.properties.database;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;

import java.util.Properties;

@Profile(value = {"database & hikari"})
@ConfigurationProperties("app.database.primary.datasource.hikari")
public class PrimaryHikariDataSourceProperties extends HikariDataSourceProperties {
    public PrimaryHikariDataSourceProperties() {
        super();
    }

    public PrimaryHikariDataSourceProperties(Properties properties) {
        super(properties);
    }

    public PrimaryHikariDataSourceProperties(String propertyFileName) {
        super(propertyFileName);
    }
}
