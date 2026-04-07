package pe.com.hlm.microservices.customer_microservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.hlm.microservices.customer_microservice.exceptions.CustomerNotFoundException;
import pe.com.hlm.microservices.customer_microservice.mapper.CustomerMapper;
import pe.com.hlm.microservices.customer_microservice.model.CustomerRequest;
import pe.com.hlm.microservices.customer_microservice.model.CustomerResponse;
import pe.com.hlm.microservices.customer_microservice.repository.CustomerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String saveCustomer(CustomerRequest request) {
        var customer = repository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public CustomerResponse getCustomerById(String customerId) {
        return repository
                .findById(customerId)
                .map(mapper::toCustomerResponse)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer not found with id: %s", customerId))
                );
    }

    public List<CustomerResponse> getCustomers() {
        return repository
                .findAll().stream()
                .map(mapper::toCustomerResponse)
                .toList();
    }

    public void deleteCustomerById(String customerId) {
        repository
                .findById(customerId)
                .orElseThrow();
        repository.deleteById(customerId);
    }

}
