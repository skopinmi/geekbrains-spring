package com.geekbrains.spring.lesson6.facade;


import com.geekbrains.spring.lesson6.data.ProductData;
import com.geekbrains.spring.lesson6.entities.Product;
import com.geekbrains.spring.lesson6.populators.ProductPopulator;
import com.geekbrains.spring.lesson6.repositories.ProductDataRepository;
import com.geekbrains.spring.lesson6.repositories.ProductRepository;
import com.geekbrains.spring.lesson6.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductFacade {

    private ProductPopulator productPopulator;
    private ProductService productService;
    private ProductDataRepository productDataRepository;

    public ProductFacade(ProductPopulator productPopulator, ProductService productService, ProductDataRepository productDataRepository) {
        this.productPopulator = productPopulator;
        this.productService = productService;
        this.productDataRepository = productDataRepository;
    }

    public ProductData getProductById(Long id){
        Product product = productService.findById(id).get();
        ProductData productData = new ProductData();
        productData.setId(product.getId());
        productData.setTitle(product.getTitle());
        productData.setBrandName(product.getBrandName());
        productData.setPrice(product.getPrice());
        return productData;
    }

    public List<ProductData> getAllProductData(){
        return productPopulator.convertAll(productService.findAll());
    }

    public List<ProductData> getAllProductDataFromRepository(){
        return productDataRepository.findAllProductData();
    }
}
