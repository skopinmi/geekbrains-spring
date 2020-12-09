package com.geekbrains.spring.lesson6.controllers.rest;


import com.fasterxml.jackson.annotation.JsonView;
import com.geekbrains.spring.lesson6.entities.Customer;
import com.geekbrains.spring.lesson6.entities.views.CommonView;
import com.geekbrains.spring.lesson6.entities.views.CustomerView;
import com.geekbrains.spring.lesson6.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.lesson6.repositories.CustomerRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers/api")
public class CustomerRestController extends CommonView {
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
// +
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(CustomerView.IdNameEmailPhoneOrders.class)
//    @JsonView(CustomerView.IdNameBirthdayEmailPhone.class)
    public Customer getCustomerById(
            @PathVariable("id") Long id
    ) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer id=" + id + " not found"));
    }

// +
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(CustomerView.IdNameEmailPhone.class)
    public List <Customer> getCustomers() {
        return customerRepository.findAll();
    }
// +
    @PostMapping
    public Customer createCustomer(
            @RequestBody Customer customer
    ) {
        return customerRepository.save(customer);
    }

// +
    @PutMapping("/{id}")
    public Customer putCustomer(
            @PathVariable("id") Long id,
            @RequestBody Customer customer
    ) {
       customerRepository.save(customer);
       return customerRepository.getOneByName(customer.getName());
    }

    // +

    @DeleteMapping("/{name}")
    public void deleteCustomer(
            @PathVariable("name") String name
    ) {
        Customer customer = customerRepository.getOneByName(name);
        customer.setName(name);
        System.out.println("name = " + name);
        customerRepository.delete(customer);
    }
}
