package com.geekbrains.spring.lesson6.facade;

import com.geekbrains.spring.lesson6.data.CustomerData;
import com.geekbrains.spring.lesson6.entities.Customer;
import com.geekbrains.spring.lesson6.populators.CustomerPopulator;
import com.geekbrains.spring.lesson6.repositories.CustomerDataRepository;
import com.geekbrains.spring.lesson6.repositories.CustomerRepository;
import com.geekbrains.spring.lesson6.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerFacade {
    private CustomerPopulator customerPopulator;
    private CustomerDataRepository customerDataRepository;
    private CustomerService customerService;

    public CustomerFacade(CustomerPopulator customerPopulator, CustomerDataRepository customerDataRepository, CustomerService customerService) {
        this.customerPopulator = customerPopulator;
        this.customerDataRepository = customerDataRepository;
        this.customerService = customerService;
    }

    public CustomerData getCustomerById(Long id){
        Customer customer = customerService.findById(id).get();
        CustomerData customerData = new CustomerData();
        customerData.setId(customer.getId());
        customerData.setName(customer.getName());
        customerData.setPhone(customer.getPhone());
        customerData.setEmail(customer.getEmail());
        customerData.setAddress(customer.getAddress());
        return customerData;
    }

    public List<CustomerData> getAllCustomerData(){
        return customerPopulator.convertAll(customerService.findAll());
    }

    public List<CustomerData> getAllCustomerDataFromRepository(){
        return customerDataRepository.findAllCustomerData();
    }

}
