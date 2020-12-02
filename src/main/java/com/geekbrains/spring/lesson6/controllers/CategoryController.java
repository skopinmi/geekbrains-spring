package com.geekbrains.spring.lesson6.controllers;

import com.geekbrains.spring.lesson6.services.CartService;
import com.geekbrains.spring.lesson6.services.CategoryService;
import com.geekbrains.spring.lesson6.services.OrderService;
import com.geekbrains.spring.lesson6.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private ProductService productService;
    private CartService cartService;
    private OrderService orderService;
    private CategoryService categoryService;

    public CategoryController(ProductService productService, CartService cartService,
                              OrderService orderService, CategoryService categoryService) {
        this.productService = productService;
        this.cartService = cartService;
        this.orderService = orderService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String showCategoriesPage() {
        return "categories";
    }



}
