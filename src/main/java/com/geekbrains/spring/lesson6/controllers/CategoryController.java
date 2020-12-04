package com.geekbrains.spring.lesson6.controllers;

import com.geekbrains.spring.lesson6.entities.Category;
import com.geekbrains.spring.lesson6.entities.Product;
import com.geekbrains.spring.lesson6.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.lesson6.services.CartService;
import com.geekbrains.spring.lesson6.services.CategoryService;
import com.geekbrains.spring.lesson6.services.OrderService;
import com.geekbrains.spring.lesson6.services.ProductService;
import com.geekbrains.spring.lesson6.utils.ProductFilter;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

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
                                     ,@RequestParam(defaultValue = "1", name = "p") Integer page) {
        page = (page < 1) ? 1 : page;
        Pageable pageable = PageRequest.of(page - 1, 15);

        model.addAttribute("categories", categoryService.findAll(pageable));
        return "categories";
    }

    @GetMapping ("/category/{id}")
    public String showAllProductsFromCategory(Model model,
                                              @PathVariable Long id,
                                              @RequestParam(defaultValue = "1", name = "p") Integer page,
                                              @RequestParam Map<String, String> params
    ) {
        page = (page < 1) ? 1 : page;

        Pageable pageable = PageRequest.of(page - 1, 5);
        ProductFilter productFilter = new ProductFilter(params);
        List <Product> products = categoryService.findById(id).getProducts();

        Page<Product> productPage = new PageImpl<>(products, pageable, 0);

        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        model.addAttribute("products", productPage);
        model.addAttribute("filterDefinition", productFilter.getFilterDefinition());
        return "/category";
    }

}
