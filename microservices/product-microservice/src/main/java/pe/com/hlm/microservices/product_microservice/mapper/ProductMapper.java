package pe.com.hlm.microservices.product_microservice.mapper;

import org.springframework.stereotype.Service;

import pe.com.hlm.microservices.product_microservice.model.Category;
import pe.com.hlm.microservices.product_microservice.model.Product;
import pe.com.hlm.microservices.product_microservice.model.dto.ProductRequest;
import pe.com.hlm.microservices.product_microservice.model.dto.ProductResponse;

@Service
public class ProductMapper {

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock(),
                product.getImageUrl(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .stock(request.stock())
                .imageUrl(request.imageUrl())
                .category(Category.builder()
                        .id(request.categoryId())
                        .build())
                .build();
    }
}
