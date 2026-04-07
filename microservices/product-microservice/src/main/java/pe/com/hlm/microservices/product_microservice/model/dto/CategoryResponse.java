package pe.com.hlm.microservices.product_microservice.model.dto;

import java.util.List;

public record CategoryResponse(
        Integer id,
        String name,
        String description,
        List<ProductResponse> products
) {

}
