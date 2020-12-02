package com.geekbrains.spring.lesson6.utils;

import com.geekbrains.spring.lesson6.entities.Category;
import com.geekbrains.spring.lesson6.entities.Customer;
import com.geekbrains.spring.lesson6.entities.Order;
import com.geekbrains.spring.lesson6.entities.Product;
import com.geekbrains.spring.lesson6.repositories.CategoryRepository;
import com.geekbrains.spring.lesson6.repositories.CustomerRepository;
import com.geekbrains.spring.lesson6.repositories.OrderRepository;
import com.geekbrains.spring.lesson6.repositories.ProductRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class SampleData {

    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private OrderRepository orderRepository;
    private CategoryRepository categoryRepository;

    public SampleData(CustomerRepository customerRepository, ProductRepository productRepository,
                      OrderRepository orderRepository, CategoryRepository categoryRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    public void init() {

        Product product1 = new Product("Orange", 50.);
        Product product2 = new Product("Lemon", 70.);
        Product product3 = new Product("Lime", 20.);
        Product product4 = new Product("Mango", 110.);
        Product product5 = new Product("Apple", 95.);
        Product product6 = new Product("Pineapple", 76.);
        Product product7 = new Product("Avocado", 123.);
        Product product8 = new Product("Chicken", 125.);

        Category category = new Category("meat");
        Category category1 = new Category("plant");

        Customer customer1 = new Customer("Alex");
        Customer customer2 = new Customer("Alena");


        List<Product> products = new ArrayList<>();
        products.add(product8);
        List<Product> products1 = new ArrayList<>();
        products1.add(product1);
        products1.add(product2);
        products1.add(product3);
        products1.add(product4);
        products1.add(product5);
        products1.add(product6);
        products1.add(product7);

        category.setProducts(products);
        category1.setProducts(products1);

        Order order1 = new Order();
        order1.setTotalPrice(product1.getPrice());
        order1.setCustomer(customer1);

        order1.setCode("0001");

        Order order2 = new Order();
        order2.setTotalPrice(product2.getPrice());
        order2.setCustomer(customer2);

        order2.setCode("0002");



        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
        productRepository.save(product6);
        productRepository.save(product7);
        productRepository.save(product8);

        categoryRepository.save(category);
        categoryRepository.save(category1);

        customerRepository.save(customer1);
        customerRepository.save(customer2);



        orderRepository.save(order1);
        orderRepository.save(order2);

    }
}
