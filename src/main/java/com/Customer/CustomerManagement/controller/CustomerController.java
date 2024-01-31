package com.Customer.CustomerManagement.controller;

import com.Customer.CustomerManagement.model.Customer;
import com.Customer.CustomerManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    // Create a customer
    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {

        String response = customerService.createCustomer(customer);

        return ResponseEntity.ok(response);
    }

    // Get a list of customers with pagination, sorting, and searching
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        List<Customer> customers = customerService.getAllCustomers(page, size);

        return ResponseEntity.ok(customers);
    }

    // Get a single customer based on ID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Customer customer = customerService.getCustomerById(id);

        return ResponseEntity.ok(customer);
    }

    // Update a customer
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {

        Customer updatedCustomer = customerService.updateCustomer(id, customer);

        return ResponseEntity.ok(updatedCustomer);
    }

    // Delete a customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {

        customerService.deleteCustomer(id);

        return ResponseEntity.noContent().build();
    }
}
