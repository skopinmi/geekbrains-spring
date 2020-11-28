package ru.geekbrains.lesson4.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.lesson4.entity.Category;
import ru.geekbrains.lesson4.entity.Product;
import ru.geekbrains.lesson4.repositories.ProductPaginationRepository;
import ru.geekbrains.lesson4.repositories.ProductRepository;
import ru.geekbrains.lesson4.services.ProductService;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductPaginationRepository productPaginationRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository, ProductPaginationRepository productPaginationRepository) {
        this.productRepository = productRepository;
        this.productPaginationRepository = productPaginationRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Product get(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void remove(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findAllByPriceGreaterThan(Double price) {
        return productRepository.findAllByPriceGreaterThanEqual(price);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAllByCategoryOrderByPrice(Category category) {
        return productRepository.findAllByCategoryOrderByPrice(category);
    }

    public Product findProductMinPrice (Category category) {
        return findAllByCategoryOrderByPrice(category).get(0);
    }

    public Product findProductMaxPrice (Category category) {
        List<Product> products = findAllByCategoryOrderByPrice(category);
        return products.get(products.size() - 1);
    }

    @Override
    public List<Product> findAllByPriceLessThan(Double price){
        return productRepository.findAllByPriceLessThan(price);
    }

    @Override
    public List<Product> findByCategoryOrderByPriceDesc(Category category) {
        return productRepository.findAllByCategoryOrderByPrice(category);
    }

    @Override
    public String findSingleMaxPrice (){
        return productRepository.findSingleMaxPrice();
    }

    @Override
    public String findSingleMinPrice (){
        return productRepository.findSingleMinPrice();
    }

    @Override
    public Product findSingleProductMaxPrice (){
        return productRepository.findSingleProductMaxPrice();
    }
}
