package pe.com.hlm.microservices.customer_microservice.model;

import lombok.Builder;

@Builder
public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        String phone,
        String address,
        String city
)  {

}
