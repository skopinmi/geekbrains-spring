package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showAll(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);

        // WEB-INF/templates/products.html
        return "products";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "product_add_form";
    }


    @PostMapping("/add")
    public String addProduct(
            @ModelAttribute Product newProduct
    ) {
        productService.saveOrUpdate(newProduct);
        return "redirect:/products/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable Long id, Model model
    ) {
        model.addAttribute("product", productService.findById(id));
        return "product_edit_form";
    }

    @PostMapping("/edit")
    public String modifyProduct(
            @ModelAttribute Product modifiedProduct
    ) {
        productService.saveOrUpdate(modifiedProduct);
        return "redirect:/products/";
    }


    @GetMapping(value = "/product/{id}")
    public String showProduct(
            @PathVariable Long id,
            Model model
    ) {
        model.addAttribute("product", productService.findById(id));
        return "product";
    }

}
