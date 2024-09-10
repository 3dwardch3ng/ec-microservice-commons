package sydney.cheng.microservice.commons.exceptions.feign;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class FeignBadRequestException extends RuntimeException {
    private Map<String, String> errors;
}
