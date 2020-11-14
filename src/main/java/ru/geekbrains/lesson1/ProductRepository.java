package ru.geekbrains.lesson1;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List <Product> productList = new ArrayList<Product>();

    public List<Product> getAllProduct () {
        return Collections.unmodifiableList(productList);
    }

    public Product getProductWithId(long id) {
        for (Product a: productList) {
            if (a.getId()==id) {
                return a;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
}
