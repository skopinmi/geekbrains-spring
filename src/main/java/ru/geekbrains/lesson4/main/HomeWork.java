package ru.geekbrains.lesson4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.geekbrains.lesson4.config.AppConfig;
import ru.geekbrains.lesson4.data.CartData;
import ru.geekbrains.lesson4.entity.*;
import ru.geekbrains.lesson4.repositories.CartDataRepository;
import ru.geekbrains.lesson4.repositories.ProductPaginationRepository;
import ru.geekbrains.lesson4.services.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeWork {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CartService cartService = applicationContext.getBean("cartService", CartService.class);
        CartEntryService cartEntryService = applicationContext.getBean("cartEntryService", CartEntryService.class);

        ProductService productService = applicationContext.getBean("productService", ProductService.class);
        CategoryService categoryService = applicationContext.getBean("categoryService", CategoryService.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);

        User user1 = new User("Alex");

        userService.save(user1);

        Category category1 = new Category("Fruit");
        Category category2 = new Category("Vegetable");

        categoryService.save(category1);
        categoryService.save(category2);

        Product product1 = new Product("Apple", 100l, 15.0, category1);
        Product product2 = new Product("Orange", 200l, 30.0, category1);
        Product product3 = new Product("Mango", 30l, 25.0, category1);
        Product product4 = new Product("Cucumber", 400l, 15.0, category2);
        Product product5 = new Product("Tomato", 150l, 20.0, category2);
        Product product6 = new Product("Potato", 20l, 10.0, category2);
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        category1.setProducts(productList);

        List<Product> productList2 = new ArrayList<>();
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        category2.setProducts(productList2);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
        productService.save(product5);
        productService.save(product6);



        Cart cart1 = new Cart();
        cart1.setCode("0001");
        cart1.setUser(user1);
        cartService.save(cart1);

        cartEntryService.addProduct(cart1, product1, 2);
        cartEntryService.addProduct(cart1, product2, 5);
        cartEntryService.addProduct(cart1, product4, 15);


//        2. Вывести каталоги с товарами в консоль.

        categoryService.getAll().stream().forEach(System.out::println);

//        a. минимальной ценой в каталоге,

        List<Product> products = productService.findAllByCategoryOrderByPrice(category1);
        System.out.println(products.get(0));

        System.out.println("less 16: " + productService.findAllByPriceLessThan(16.0));

//        b. максимальной ценой из общего списка,

        List<Product> products1 = productService.findAllByCategoryOrderByPrice(category1);
        System.out.println("Max price: " + products1.get(products1.size() - 1));

        System.out.println("Max price: " + productService.findSingleProductMaxPrice());


//        c. минимальной и максимальной цене в каталог
        System.out.println("макс " + productService.findByCategoryOrderByPriceDesc(category1).get(0));
        System.out.println("макс " + productService.findByCategoryOrderByPriceDesc(category1).get(0));

        System.out.println(productService.findSingleMaxPrice());
        System.out.println(productService.findSingleMinPrice());

        System.out.println(productService.findSingleProductMaxPrice());

//        Pageable pageable = PageRequest.of(0, 1);
//
//        Page<Product> productPage = productService.getAll(pageable);
//        System.out.println(productPage.getContent());
    }
}
