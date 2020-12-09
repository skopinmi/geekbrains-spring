package com.geekbrains.spring.lesson6.controllers.rest;


import com.fasterxml.jackson.annotation.JsonView;
import com.geekbrains.spring.lesson6.data.CustomerData;
import com.geekbrains.spring.lesson6.entities.Customer;
import com.geekbrains.spring.lesson6.entities.views.CommonView;
import com.geekbrains.spring.lesson6.entities.views.CustomerView;
import com.geekbrains.spring.lesson6.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.lesson6.facade.CustomerFacade;
import com.geekbrains.spring.lesson6.repositories.CustomerRepository;
import com.geekbrains.spring.lesson6.services.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers/api")
public class CustomerRestController extends CommonView {
    private CustomerService customerService;
    private CustomerFacade customerFacade;
    private CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository, CustomerService customerService, CustomerFacade customerFacade) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
        this.customerFacade = customerFacade;
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    @JsonView(CustomerView.IdNameBirthdayEmailPhone.class)
    public List<Customer> customersToXml() {
        return customerService.findAll();
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(CustomerView.IdNameBirthdayEmailPhone.class)
    public List<Customer> customersToJson() {
        return customerService.findAll();
    }
// +
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(CustomerView.IdNameEmailPhoneOrders.class)
//    @JsonView(CustomerView.IdNameBirthdayEmailPhone.class)
    public Customer getCustomerById(
            @PathVariable("id") Long id
    ) {
        return customerService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer id=" + id + " not found"));
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

    // test CustomerData +

    @GetMapping(value = "/data/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CustomerData getCustomerByIdData(
            @PathVariable("id") Long id
    ) {
        return customerFacade.getCustomerById(id);
    }

    // test Customer Populator +

    @GetMapping(value = "/dataP")
    public List<CustomerData> getCustomerByIdDataPop() {
        return customerFacade.getAllCustomerData();
    }
    // test Customer DateRepository +

    @GetMapping(value = "/dataR")
    public List<CustomerData> getCustomerByIdDataRep() {
        return customerFacade.getAllCustomerDataFromRepository();
    }
}
