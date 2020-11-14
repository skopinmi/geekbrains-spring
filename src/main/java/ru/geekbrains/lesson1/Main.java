package ru.geekbrains.lesson1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        System.out.println(productRepository.getAllProduct());
        CartService cartService = context.getBean("cartService", CartService.class);
        cartService.addToCart(1l);
        cartService.addToCart(3l);
        System.out.println("My cart price : " + cartService.priceOfCart());
//        CartService cartService1 = context.getBean("cartService", CartService.class);
//        System.out.println("My cart price : " + cartService1.priceOfCart());
//        cartService.deleteFromCart(3l);
//        cartService1.addToCart(3l);
//        System.out.println("My cart price " + cartService.getClass().getSimpleName() + " : " + cartService.priceOfCart());
//        System.out.println("My cart price " + cartService1.getClass().getSimpleName() + " : " + cartService1.priceOfCart());
    }
}
