package ru.geekbrains.lesson4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.lesson4.entity.Category;
import ru.geekbrains.lesson4.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceGreaterThanEqual(Double price);
    Product findByName(String name);
    List<Product> findAllByCategoryOrderByPrice(Category category);
    List<Product> findAllByPriceLessThan(Double price);


//  пробовал

    @Query("select Max(p.price) from Product p")
    String findSingleMaxPrice();

    @Query("select Min(p.price) from Product p")
    String findSingleMinPrice();

    @Query("select p from Product p where p.price = (select Max(p.price) from Product p)")
    Product findSingleProductMaxPrice();

    @Query("select p from Product p where p.price = (select Min(p.price) from Product p)")
    Product findSingleProductMinPrice();
}
