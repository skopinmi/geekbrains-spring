package ru.geekbrains.lesson4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.lesson4.config.AppConfig;
import ru.geekbrains.lesson4.data.CartData;
import ru.geekbrains.lesson4.entity.Cart;
import ru.geekbrains.lesson4.entity.Category;
import ru.geekbrains.lesson4.entity.Product;
import ru.geekbrains.lesson4.entity.User;
import ru.geekbrains.lesson4.repositories.CartDataRepository;
import ru.geekbrains.lesson4.services.*;

import java.util.ArrayList;
import java.util.List;

public class MainData {

    public static void main(String[] args) {

//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        CartService cartService = applicationContext.getBean("cartService", CartService.class);
//        CartEntryService cartEntryService = applicationContext.getBean("cartEntryService", CartEntryService.class);
//        ProductService productService = applicationContext.getBean("productService", ProductService.class);
//        CategoryService categoryService = applicationContext.getBean("categoryService", CategoryService.class);
//        UserService userService = applicationContext.getBean("userService", UserService.class);
//
//        CartDataRepository cartDataRepository = applicationContext.getBean("cartDataRepository", CartDataRepository.class);
//
//        User user1 = new User("Alex");
//
//        userService.save(user1);
//
////        Product product1 = new Product("Apple", 100l, 15.0);
////        Product product2 = new Product("Orange", 200l, 30.0);
////        Product product3 = new Product("Mango", 30l, 25.0);
////        Product product4 = new Product("Cucumber", 400l, 15.0);
////        Product product5 = new Product("Tomato", 150l, 20.0);
////        Product product6 = new Product("Potato", 20l, 10.0);
//
//        Category category1 = new Category("Fruit");
//        Category category2 = new Category("Vegetable");
//
//
//
////        productService.save(product1);
////        productService.save(product2);
////        productService.save(product3);
////        productService.save(product4);
////        productService.save(product5);
////        productService.save(product6);
//
////        category1.addProducts(product1);
////        category1.addProducts(product2);
////        category1.addProducts(product3);
////
////        category2.addProducts(product4);
////        category2.addProducts(product5);
////        category2.addProducts(product6);
//
//        categoryService.save(category1);
//        categoryService.save(category2);
////        categoryService.addProduct(category1, product1);
////        categoryService.addProduct(category1, product2);
////        categoryService.addProduct(category1, product3);
////        categoryService.addProduct(category2, product4);
////        categoryService.addProduct(category2, product5);
////        categoryService.addProduct(category2, product6);
//
//        Cart cart1 = new Cart();
//        cart1.setCode("0001");
//        cart1.setUser(user1);
//        cartService.save(cart1);
//
////        cartEntryService.addProduct(cart1, product1, 2);
////        cartEntryService.addProduct(cart1, product2, 5);
////        cartEntryService.addProduct(cart1, product3, 15);
//
//
//        CartData cartData = cartDataRepository.findByCode("0001");
//
//        System.out.println("cartData = " + cartData);
    }
}
