package com.geekbrains.spring.lesson6.services;

import com.geekbrains.spring.lesson6.entities.Category;
import com.geekbrains.spring.lesson6.entities.Product;
import com.geekbrains.spring.lesson6.repositories.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private OrderService orderService;
    private CategoryRepository categoryRepository;
    private ProductService productService;

    public CategoryService(OrderService orderService, CategoryRepository categoryRepository,
                           ProductService productService) {
        this.orderService = orderService;
        this.categoryRepository = categoryRepository;
        this.productService = productService;
    }

    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }


    public List<Product> findAllProductsById(Long id) {
        return categoryRepository.findAllProductsById(id);
    }

    public Category findById(Long id) {
        return categoryRepository.getOne(id);
    }
}
