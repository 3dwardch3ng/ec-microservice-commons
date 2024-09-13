package sydney.cheng.microservice.commons.configuration.properties.database;

import lombok.Data;
import org.springframework.context.annotation.Profile;

import java.io.Serializable;

@Profile("database")
@Data
public class DatabaseNodeProperties implements Serializable {
    private HikariDataSourceProperties hikari;
}
