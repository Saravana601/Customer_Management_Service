package com.Customer.CustomerManagement.service;

import com.Customer.CustomerManagement.model.Customer;
import com.Customer.CustomerManagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public String createCustomer(Customer customer) {
        customerRepository.save(customer);
        return "Customer created successfully";
    }

    public List<Customer> getAllCustomers(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo,pageSize);

        Page<Customer> customerPage = customerRepository.findAll(paging);

        if(customerPage.hasContent())
            return customerPage.getContent();

        return new ArrayList<>();
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer updateCustomer(Integer id, Customer updatedCustomer) {
        return customerRepository.findById(id)
                .map(existingCustomer -> {
                    existingCustomer.setFirst_name(updatedCustomer.getFirst_name());
                    existingCustomer.setLast_name(updatedCustomer.getLast_name());
                    existingCustomer.setStreet(updatedCustomer.getStreet());
                    existingCustomer.setAddress(updatedCustomer.getAddress());
                    existingCustomer.setCity(updatedCustomer.getCity());
                    existingCustomer.setState(updatedCustomer.getState());
                    existingCustomer.setEmail(updatedCustomer.getEmail());
                    existingCustomer.setPhone(updatedCustomer.getPhone());

                    return customerRepository.save(existingCustomer);
                })
                .orElse(null); // Customer not found
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}