package sydney.cheng.microservice.commons.exceptions.feign;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class FeignErrorException extends RuntimeException {
    private final String message;
    private final HttpStatus httpStatus;

    public FeignErrorException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
