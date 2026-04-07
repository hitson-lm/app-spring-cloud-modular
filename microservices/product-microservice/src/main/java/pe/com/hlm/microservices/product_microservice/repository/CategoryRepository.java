package pe.com.hlm.microservices.product_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.hlm.microservices.product_microservice.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
