package pe.com.hlm.microservices.customer_microservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true) // anotación para que el método equals y hashCode se generen correctamente, teniendo en cuenta los campos de la clase padre (RuntimeException)
@Data
public class CustomerNotFoundException extends RuntimeException {
    private final String message;
}
