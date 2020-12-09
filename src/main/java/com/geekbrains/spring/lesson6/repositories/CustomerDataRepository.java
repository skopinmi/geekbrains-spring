package com.geekbrains.spring.lesson6.repositories;

import com.geekbrains.spring.lesson6.data.CustomerData;
import com.geekbrains.spring.lesson6.data.ProductData;
import com.geekbrains.spring.lesson6.entities.Customer;
import com.geekbrains.spring.lesson6.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDataRepository extends JpaRepository<Customer, Long> {

    @Query("select new com.geekbrains.spring.lesson6.data.CustomerData(c.id, c.name, c.phone, c.email, c.address) from Customer c")
    List<CustomerData> findAllCustomerData();
}
