package sydney.cheng.microservice.commons.configuration.properties.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "app.security.oauth2")
public class OAuth2Properties {
    private RemoteTokenCheckProperties remoteTokenCheck;

    @Getter
    @Setter
    public static class RemoteTokenCheckProperties {
        String checkTokenUrl;
        String clientId;
        String clientSecret;
    }
}
