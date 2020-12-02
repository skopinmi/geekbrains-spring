package com.geekbrains.spring.lesson6.controllers;

import com.geekbrains.spring.lesson6.entities.Category;
import com.geekbrains.spring.lesson6.services.CartService;
import com.geekbrains.spring.lesson6.services.CategoryService;
import com.geekbrains.spring.lesson6.services.OrderService;
import com.geekbrains.spring.lesson6.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/categories")
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
    public String showCategoriesPage(Model model
                                     ,@RequestParam(defaultValue = "1", name = "p") Integer page
//                                     ,@RequestParam Map<String, String> params
    ) {
        page = (page < 1) ? 1 : page;
//        CategoryFilter categoryFilter = new CategoryFilter(params);
//        Page<Category> categories = PageRequest.of ategoryService.findAll();
        Pageable pageable = PageRequest.of(page, 5);

        model.addAttribute("categories", categoryService.findAll(pageable));
        return "categories";
    }


}
