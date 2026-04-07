package pe.com.hlm.microservices.product_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.hlm.microservices.product_microservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
