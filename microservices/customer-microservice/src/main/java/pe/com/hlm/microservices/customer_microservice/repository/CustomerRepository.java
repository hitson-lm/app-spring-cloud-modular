package pe.com.hlm.microservices.customer_microservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pe.com.hlm.microservices.customer_microservice.model.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

}