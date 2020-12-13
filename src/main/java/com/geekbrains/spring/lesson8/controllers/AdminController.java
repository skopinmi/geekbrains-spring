package com.geekbrains.spring.lesson8.controllers;

import com.geekbrains.spring.lesson8.data.UserData;
import com.geekbrains.spring.lesson8.entities.Order;
import com.geekbrains.spring.lesson8.entities.Product;
import com.geekbrains.spring.lesson8.entities.User;
import com.geekbrains.spring.lesson8.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.lesson8.facade.UserFacade;
import com.geekbrains.spring.lesson8.services.OrderService;
import com.geekbrains.spring.lesson8.services.ProductService;
import com.geekbrains.spring.lesson8.services.UserService;
import com.geekbrains.spring.lesson8.utils.OrderFilter;
import com.geekbrains.spring.lesson8.utils.ProductFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private ProductService productService;
    private OrderService orderService;
    private UserService userService;
    private UserFacade userFacade;

    public AdminController(ProductService productService, OrderService orderService, UserService userService
                   , UserFacade userFacade
    ) {
        this.productService = productService;
        this.orderService = orderService;
        this.userService = userService;
        this.userFacade = userFacade;
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/products")
    public String showAllProducts(Model model,
                                  @RequestParam(defaultValue = "1", name = "p") Integer page,
                                  @RequestParam Map<String, String> params
    ) {
        page = (page < 1) ? 1 : page;
        ProductFilter productFilter = new ProductFilter(params);
        Page<Product> products = productService.findAll(productFilter.getSpec(), page - 1, 5);
        model.addAttribute("products", products);
        model.addAttribute("filterDefinition", productFilter.getFilterDefinition());
        productService.getProductByMaxPrice();

        return "products";
    }

    @GetMapping("/users")
    public String showAllUsers(Model model,
                               @RequestParam(defaultValue = "1", name = "p") Integer page
//            ,
//                                  @RequestParam Map<String, String> params
    ) {
//        page = (page < 1) ? 1 : page;
//        Pageable pageable = PageRequest.of(page, 5);
//        ProductFilter productFilter = new ProductFilter(params);
//        Page<User> users = userService.getAllUser(pageable);
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
//        model.addAttribute("filterDefinition", productFilter.getFilterDefinition());
//        productService.getProductByMaxPrice();
        return "users";
    }

    @GetMapping("/add")
    public String addProduct(
            Model model
    ) {
        model.addAttribute("product", new Product());
        return "product_add_form";
    }

    @PostMapping("/add")
    public String addProduct(
            @Valid @ModelAttribute Product product,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "product_add_form";
        }
        productService.addProduct(product);
        return "redirect:/products";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product p = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " doesn't exists (for edit)"));
        model.addAttribute("product", p);
        return "product_edit_form";
    }


    @PostMapping("/edit")
    public String showEditForm(@ModelAttribute Product product) {
        productService.saveOrUpdate(product);
        return "redirect:/products";
    }


    @GetMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String deleteOneProductById(@PathVariable Long id) {
        productService.deleteById(id);
        return "ok";
    }


    @GetMapping("/orders")
    public String orders(
            @RequestParam Map<String, String> params,
            Model model
    ) {
        OrderFilter orderFilter = new OrderFilter(params);
        List<Order> orders = orderService.findAll(orderFilter.getSpec());
        model.addAttribute("orders", orders);
        return "orders";
    }


    @GetMapping("/orders/remove/{id}")
    public String remove(
            @PathVariable("id") Long id,
            Model model
    ) {
        orderService.remove(id);
        return "redirect:/orders";
    }
}
