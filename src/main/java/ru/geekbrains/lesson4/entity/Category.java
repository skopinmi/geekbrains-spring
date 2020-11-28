package ru.geekbrains.lesson4.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "categories")
//@NamedQuery(name = "withProducts", query = "SELECT c FROM Category c JOIN FETCH c.products WHERE c.id = :id")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            mappedBy = "category",
            fetch = FetchType.EAGER
    )
    List<Product> products;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }


//    public Category(String name, List<Product> products) {
//        this.products = products;
//        this.name = name;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProducts(Product product) {
        products.add(product);
    }

    public void removeProducts(Product product) {
        products.remove(product);
    }

    public Long getId() {
        return id;
    }

//    public long getVersion() {
//        return version;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return
//                version == category.version &&
                Objects.equals(id, category.id) &&
                Objects.equals(name, category.name) &&
                Objects.equals(products, category.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, products);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
//                ", version=" + version +
                '}';
    }
}
