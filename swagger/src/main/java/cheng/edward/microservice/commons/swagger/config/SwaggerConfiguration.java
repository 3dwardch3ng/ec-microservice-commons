package cheng.edward.microservice.commons.swagger.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "MediRecords Secure Message API", version = "v1"))
@SecurityScheme(
        name = "Authentication Token",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
public class SwaggerConfiguration {
}
