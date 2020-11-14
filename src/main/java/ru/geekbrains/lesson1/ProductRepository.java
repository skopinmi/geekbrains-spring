package ru.geekbrains.lesson1;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List <Product> productList = new ArrayList<Product>();

    @PostConstruct
    public void init(){
        productList.add(new Product(1l, "pr1", 100d));
        productList.add(new Product(2l, "pr2", 110d));
        productList.add(new Product(3l, "pr3", 111d));
        productList.add(new Product(4l, "pr4", 11d));
        productList.add(new Product(5l, "pr5", 1d));
    }
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
