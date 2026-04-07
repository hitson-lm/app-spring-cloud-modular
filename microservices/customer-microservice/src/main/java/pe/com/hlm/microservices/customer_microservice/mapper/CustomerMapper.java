package pe.com.hlm.microservices.customer_microservice.mapper;

import org.springframework.stereotype.Component;
import pe.com.hlm.microservices.customer_microservice.model.Customer;
import pe.com.hlm.microservices.customer_microservice.model.CustomerRequest;
import pe.com.hlm.microservices.customer_microservice.model.CustomerResponse;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequest request) {
        return Customer.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .address(request.address())
                .city(request.city())
                .build();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .address(customer.getAddress())
                .city(customer.getCity())
                .build();
    }

}