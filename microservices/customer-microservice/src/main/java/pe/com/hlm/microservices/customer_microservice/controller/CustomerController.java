package pe.com.hlm.microservices.customer_microservice.controller;

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
import pe.com.hlm.microservices.customer_microservice.model.CustomerRequest;
import pe.com.hlm.microservices.customer_microservice.model.CustomerResponse;
import pe.com.hlm.microservices.customer_microservice.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @PostMapping("/customers")
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(service.saveCustomer(request));
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable("customerId") String customerId) {
        return ResponseEntity.ok(service.getCustomerById(customerId));//
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponse>> getCustomers() {
        return ResponseEntity.ok(service.getCustomers());
    }

    @PutMapping("/customers")
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CustomerRequest request) {
        service.saveCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("customerId") String customerId) {
        service.deleteCustomerById(customerId);
        return ResponseEntity.accepted().build();
    }


}
