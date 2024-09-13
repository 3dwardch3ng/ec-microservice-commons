package sydney.cheng.microservice.commons.configuration.properties.database;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Profile;

import java.io.Serializable;

@Profile("database")
@EqualsAndHashCode(callSuper = true)
@Data
public class DataSourceProperties extends org.springframework.boot.autoconfigure.jdbc.DataSourceProperties implements Serializable {
    private HikariDataSourceProperties hikari;

    public DataSourceProperties() {
        super();
    }
}
