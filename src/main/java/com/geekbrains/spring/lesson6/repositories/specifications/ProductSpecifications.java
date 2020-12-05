package com.geekbrains.spring.lesson6.repositories.specifications;

import com.geekbrains.spring.lesson6.entities.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {
    public static Specification<Product> priceGreaterOrEqualsThan(int minPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);  // where p.price >= minPrice
    }

    public static Specification<Product> priceLesserOrEqualsThan(int maxPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice); // where p.price <= maxPrice
    }

    public static Specification<Product> titleLike(String titlePart) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), String.format("%%%s%%", titlePart)); // where p.title like %titlePart%
    }

    public static Specification<Product> allInCategory(Long id) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("category_id"), id);
    }
}