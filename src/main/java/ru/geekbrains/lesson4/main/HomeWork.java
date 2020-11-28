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


        System.out.println("каталог товаров :");
        categoryService.getAll().stream().forEach(System.out::println);
//        a. минимальной ценой в каталоге,
//        b. максимальной ценой из общего списка,
//        c. минимальной и максимальной цене в каталог
        List<Product> products = productService.findAllByCategoryOrderByPrice(category1);
        System.out.println(products.get(0));

        System.out.println(products.get(products.size() - 1));

//        List<Product>

        System.out.println(productService.findAllOrderByPrice().get(0));


//        System.out.println(productService.findOneAsc());
//        System.out.println(productService.getAll().stream().sorted().findFirst());
//        System.out.println(productService.findOneDesc());


//        categoryService.getAll().stream().filter(x -> x.getId()==1).forEach(System.out::println);
//        cartService.findCartByUser(user1).getCartEntryList().stream().forEach(System.out::println);
//        cartService.findCartByUser(user1).getCartEntryList().stream().filter(x -> x.getProduct().getCategory().equals(category1)).forEach(System.out::println);
    }
}
