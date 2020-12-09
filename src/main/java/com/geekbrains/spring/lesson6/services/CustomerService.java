package com.geekbrains.spring.lesson6.services;

import com.geekbrains.spring.lesson6.entities.Customer;
import com.geekbrains.spring.lesson6.entities.Product;
import com.geekbrains.spring.lesson6.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

}
