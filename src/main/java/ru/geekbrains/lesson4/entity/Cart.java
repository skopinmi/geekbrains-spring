package ru.geekbrains.lesson4.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @OneToMany(
            mappedBy = "cart",
            fetch = FetchType.EAGER
    )
    List<CartEntry> cartEntryList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<CartEntry> getCartEntryList() {
        return cartEntryList;
    }

    public void setCartEntryList(List<CartEntry> cartEntryList) {
        this.cartEntryList = cartEntryList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id.equals(cart.id) &&
                code.equals(cart.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", cartEntryList=" + cartEntryList +
                ", user=" + user +
                '}';
    }
}
