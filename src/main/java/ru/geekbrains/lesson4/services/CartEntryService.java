package ru.geekbrains.lesson4.services;

import ru.geekbrains.lesson4.entity.Cart;
import ru.geekbrains.lesson4.entity.CartEntry;
import ru.geekbrains.lesson4.entity.Product;

import java.util.List;

public interface CartEntryService {

    CartEntry get(Long id);
    List<CartEntry> getAll();
    void save(CartEntry cartEntry);
    void remove(CartEntry cartEntry);
    CartEntry addProduct(Cart cart, Product product, Integer quantity);
}
