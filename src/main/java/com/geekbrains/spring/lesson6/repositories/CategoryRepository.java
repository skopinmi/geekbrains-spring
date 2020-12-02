package com.geekbrains.spring.lesson6.repositories;

import com.geekbrains.spring.lesson6.entities.Category;
import com.geekbrains.spring.lesson6.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends  PagingAndSortingRepository<Category, Long>, JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
    List<Product> findAllProductsById(Long id);
}
