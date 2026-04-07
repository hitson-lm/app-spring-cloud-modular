package pe.com.hlm.microservices.product_microservice.model.dto;

import jakarta.validation.constraints.NotNull;

public record CategoryRequest(
        Integer id,
        @NotNull(message = "Category name is required")
        String name,
        String description
) {}
