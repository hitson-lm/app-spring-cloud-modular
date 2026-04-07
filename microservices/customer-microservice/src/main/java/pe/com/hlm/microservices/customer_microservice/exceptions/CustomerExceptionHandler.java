package pe.com.hlm.microservices.customer_microservice.exceptions;

import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// uso del modulo common-exceptions para manejar la excepciones propias del microservicio.
import pe.com.hlm.microservices.common_exceptions.ErrorResponse;
import pe.com.hlm.microservices.common_exceptions.GlobalExceptionHandler;

@RestControllerAdvice(basePackages = "pe.com.hlm.microservices.customer_microservice") // Especifica que esta clase se aplicará a los controladores dentro del paquete "pe.com.hlm.microservices.customer_microservice".
@Primary // Indica que esta clase es la principal para manejar excepciones en el contexto de la aplicación.
@Slf4j
public class CustomerExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle (CustomerNotFoundException exception) {

        var errors = new HashMap<String, String>();
        var fieldName = "customer";
        errors.put(fieldName, exception.getMessage());
        log.warn("CustomerNotFoundException: {}", exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));

    }

}
