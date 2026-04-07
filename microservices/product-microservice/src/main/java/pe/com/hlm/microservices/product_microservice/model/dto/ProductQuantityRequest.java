package pe.com.hlm.microservices.product_microservice.model.dto;

import jakarta.validation.constraints.NotNull;

public record ProductQuantityRequest(
        @NotNull(message = "Product ID cannot be null")
        Integer productId,
        @NotNull(message = "Quantity cannot be null")
        Integer quantity
) {

}