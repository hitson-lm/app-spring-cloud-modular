package pe.com.hlm.microservices.product_microservice.mapper;

import org.springframework.stereotype.Component;
import pe.com.hlm.microservices.product_microservice.model.Category;
import pe.com.hlm.microservices.product_microservice.model.dto.CategoryRequest;
import pe.com.hlm.microservices.product_microservice.model.dto.CategoryResponse;
import pe.com.hlm.microservices.product_microservice.model.dto.ProductResponse;

@Component
public class CategoryMapper {

    public Category toCategory(CategoryRequest request) {
        return  Category.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .build();
    }

    public CategoryResponse toCategoryResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getProducts().stream()
                        .map(product -> new ProductResponse(
                                product.getId(),
                                product.getName(),
                                product.getDescription(),
                                product.getPrice(),
                                product.getStock(),
                                product.getImageUrl(),
                                product.getCategory().getId(),
                                product.getCategory().getName(),
                                product.getCategory().getDescription(
                                )))
                        .toList()
        );
    }
}
