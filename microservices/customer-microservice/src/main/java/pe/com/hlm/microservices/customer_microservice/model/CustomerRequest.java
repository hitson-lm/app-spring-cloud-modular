package pe.com.hlm.microservices.customer_microservice.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "First name is required")
        @NotBlank(message = "First name cannot be blank")
        String firstName,
        @NotNull(message = "Last name is required")
        String lastName,
        @NotNull(message = "Email is required")
        @Email(message = "Email is not valid")
        String email,
        String phone,
        String address,
        String city
)  {

}
