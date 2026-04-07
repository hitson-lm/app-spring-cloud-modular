package pe.com.hlm.microservices.product_microservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import pe.com.hlm.microservices.product_microservice.model.dto.ProductQuantityRequest;
import pe.com.hlm.microservices.product_microservice.model.dto.ProductRequest;
import pe.com.hlm.microservices.product_microservice.model.dto.ProductResponse;
import pe.com.hlm.microservices.product_microservice.service.ProductService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping("/products")
    public ResponseEntity<Integer> createProduct(@Valid @RequestBody ProductRequest product) {
        return ResponseEntity.ok(service.createProduct(product));
    }

    @GetMapping("/products")
    public List<ProductResponse> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/products/category/{id}")
    public List<ProductResponse> getProductsByCategoryId(@PathVariable Integer id) {
        return service.getProductsByCategoryId(id);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getProductById(id));
    }

    @PutMapping("/products")
    public ResponseEntity<Integer> updateProduct(@Valid @RequestBody ProductRequest product) {
        return ResponseEntity.ok(service.updateProduct(product));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        service.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/products/purchase")
    public ResponseEntity<Void> purchaseProduct(@Valid @RequestBody List<ProductQuantityRequest> request) {
        service.purchaseProduct(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/products/restock")
    public ResponseEntity<Void> updateProductStock(@Valid @RequestBody List<ProductQuantityRequest> request) {
        service.restockProduct(request);
        return ResponseEntity.ok().build();
    }

}