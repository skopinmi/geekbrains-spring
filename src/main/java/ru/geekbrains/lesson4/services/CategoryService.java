package ru.geekbrains.lesson4.services;

import ru.geekbrains.lesson4.entity.Category;
import ru.geekbrains.lesson4.entity.Product;

import java.util.List;

public interface CategoryService {
    Category get(Long id);
    List<Category> getAll();
    void save(Category category);
    void remove(Category category);

}
