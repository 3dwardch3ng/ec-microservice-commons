package sydney.cheng.microservice.commons.configuration.properties.auth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app.security.url")
public class UrlProperties {
    private String frontend;
    private String backend;
    private String gateway;
    private String frontendDefaultLogin;
}
