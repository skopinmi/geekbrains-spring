package ru.geekbrains.lesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class CartService {

    private ProductRepository productRepository;
    private List<Product> cartList = new ArrayList<Product>();

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addToCart (long id) {
        cartList.add(productRepository.getProductWithId(id));
    }

    public void deleteFromCart (long id) {
        cartList.remove(productRepository.getProductWithId(id));
    }

    public int priceOfCart () {
        int price = 0;
        for (Product a: cartList) {
            price += a.getPrice();
        }
        return price;
    }
}
