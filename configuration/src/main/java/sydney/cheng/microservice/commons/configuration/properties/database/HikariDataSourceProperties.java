package sydney.cheng.microservice.commons.configuration.properties.database;

import com.zaxxer.hikari.HikariConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Profile;

import java.io.Serializable;
import java.util.Properties;

@Profile(value = {"database & hikari"})
@EqualsAndHashCode(callSuper = true)
@Data
public class HikariDataSourceProperties extends HikariConfig implements Serializable {
    private String urlPrefix;

    public HikariDataSourceProperties() {
        super();
    }

    public HikariDataSourceProperties(Properties properties) {
        super(properties);
    }

    public HikariDataSourceProperties(String propertyFileName) {
        super(propertyFileName);
    }
}
