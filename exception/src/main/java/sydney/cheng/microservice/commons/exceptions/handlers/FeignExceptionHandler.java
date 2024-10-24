package sydney.cheng.microservice.commons.exceptions.handlers;

import sydney.cheng.microservice.commons.exceptions.feign.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class FeignExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FeignErrorException.class)
    public ResponseEntity<?> genericError(FeignErrorException exception) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", exception.getMessage());
        return new ResponseEntity<>(errors, exception.getHttpStatus());
    }

    @ExceptionHandler(FeignBadRequestException.class)
    public ResponseEntity<?> validationException(FeignBadRequestException exception) {
        return ResponseEntity.badRequest().body(exception.getErrors());
    }
}
