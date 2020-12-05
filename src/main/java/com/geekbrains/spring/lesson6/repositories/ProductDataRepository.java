package com.geekbrains.spring.lesson6.repositories;

import com.geekbrains.spring.lesson6.data.ProductData;
import com.geekbrains.spring.lesson6.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDataRepository extends JpaRepository<Product, Long> {

    @Query("select new com.geekbrains.spring.lesson6.data.ProductData(p.id, p.title, p.brandName, p.price, p.createDate, p.modifyDate) from Product p")
    List<ProductData> findAllProductData();

}
