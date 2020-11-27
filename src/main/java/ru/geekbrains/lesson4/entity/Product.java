package ru.geekbrains.lesson4.entity;

import org.hibernate.annotations.OptimisticLock;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "price")
    private Double price;

//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;

    @Column(name = "something")
    @OptimisticLock(excluded = true)
    private String something;

    @Version
    long version;

    public Product() {
    }

    public Product(String name, Long quantity, Double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

//    public Product(String name, Long quantity, Double price, Category category) {
//        this.name = name;
//        this.quantity = quantity;
//        this.price = price;
//        this.category = category;
//    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSomething() {
        return something;
    }

    public void setSomething(String something) {
        this.something = something;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public long getVersion() {
        return version;
    }

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
//                ", category=" + category +
                ", something='" + something + '\'' +
                ", version=" + version +
                '}';
    }
}
