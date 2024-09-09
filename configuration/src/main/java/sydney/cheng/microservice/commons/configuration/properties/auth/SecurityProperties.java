package sydney.cheng.microservice.commons.configuration.properties.auth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("app.security")
public class SecurityProperties {
    private UrlProperties url;
    private CorsProperties cors;
    private OAuth2Properties oauth2;
}
