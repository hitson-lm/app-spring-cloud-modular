package pe.com.hlm.microservices.common_exceptions;

import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // Handle Exception para "Validation Jakarta" -> MethodArgumentNotValidException.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exception) {

        var errors = new HashMap<String, String>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            var fieldName = error.getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        log.warn("Validation error: {}", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }

    // Handle Exception para cualquier otra excepción no controlada -> Exception.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        var errors = new HashMap<String, String>();
        var fieldName = "message";
        var errorMessage = "An error has occurred. Please contact the administrator or try again later.";
        errors.put(fieldName, errorMessage);
        log.error("An error has occurred: {}", exception.toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(errors));

    }

}
