package com.geekbrains.spring.lesson6.controllers.rest;


import com.geekbrains.spring.lesson6.entities.Customer;
import com.geekbrains.spring.lesson6.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.lesson6.repositories.CustomerRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers/api")
public class CustomerRestController {
    private CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Customer> customersToXml() {
        return customerRepository.findAll();
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> customersToJson() {
        return customerRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerById(
            @PathVariable("id") Long id
    ) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer id=" + id + " not found"));
    }

    @PostMapping
    public Customer createCustomer(
            @RequestBody Customer customer
    ) {
        return customerRepository.save(customer);
    }

    @PutMapping("/{name}")
    public Customer putCustomer(
            @PathVariable("name") Long name,
            @RequestBody Customer customer
    ) {
        return customerRepository.save(customer);
    }

    // ???

    @DeleteMapping("/{name}")
    public void deleteCustomer(
            @PathVariable("name") String name
    ) {
        Customer customer = new Customer();
        customer.setName(name);
        System.out.println("name = " + name);
        customerRepository.delete(customer);
    }
}
