package sydney.cheng.microservice.commons.configuration.properties.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "app.security.cors")
public class CorsProperties {
    private String allowedUrls;
    private String allowedOrigins;
    private List<String> allowedHeaders;
    private List<String> allowedMethods;
    private long allowedMaxAge = 3600;
    private boolean allowCredentials = true;

    public List<String> getAllowedUrlList() {
        return Arrays.asList(allowedUrls.split(","));
    }

    public List<String> getAllowedOriginList() {
        return Arrays.asList(allowedOrigins.split(","));
    }
}
