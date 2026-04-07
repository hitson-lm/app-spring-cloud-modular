package pe.com.hlm.microservices.product_microservice.model.dto;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        Double price,
        Integer stock,
        String imageUrl,
        Integer categoryId,
        String categoryName,
        String categoryDescription
) {

}
