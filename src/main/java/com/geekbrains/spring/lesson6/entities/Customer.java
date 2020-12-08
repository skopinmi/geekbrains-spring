package com.geekbrains.spring.lesson6.entities;

import com.fasterxml.jackson.annotation.JsonView;
import com.geekbrains.spring.lesson6.entities.views.CommonView;
import com.geekbrains.spring.lesson6.entities.views.CustomerView;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer extends AbstractItem {

    @Column(name = "name")
    @JsonView (CustomerView.IdName.class)
    private String name;

    @Column(name = "email")
    @JsonView (CustomerView.IdNameBirthdayEmailPhone.class)
    private String email;

    @Column(name = "phone")
    @JsonView (CustomerView.IdNameEmailPhone.class)
    private String phone;

    @Column(name = "birthday")
    @JsonView (CustomerView.IdNameBirthday.class)
    private Date birthday;

    @Column(name = "address")
    @JsonView (CustomerView.IdNameEmailPhone.class)
    private String address;

    @Column(name = "description")
    @JsonView (CustomerView.IdNameEmailPhoneOrders.class)
    private String description;

    @OneToMany(mappedBy = "customer")
    @JsonView (CustomerView.IdNameEmailPhoneOrders.class)
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String name, String email, String phone, Date birthday, String address, String description) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.address = address;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
