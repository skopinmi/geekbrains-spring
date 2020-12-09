package com.geekbrains.spring.lesson6.data;

import com.fasterxml.jackson.annotation.JsonView;
import com.geekbrains.spring.lesson6.entities.Order;
import com.geekbrains.spring.lesson6.entities.views.CustomerView;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

public class CustomerData {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private Date birthday;
    private String address;
    private String description;
    private List<Order> orders;

    public CustomerData() {
    }

//    public CustomerData(Long id, String name, String email, String phone, Date birthday) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.phone = phone;
//        this.birthday = birthday;
//    }

    public CustomerData(Long id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

//    public CustomerData(Long id, String name, String email, String phone, String address, String description, List<Order> orders) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.phone = phone;
//        this.address = address;
//        this.description = description;
//        this.orders = orders;
//    }

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

    @Override
    public String toString() {
        return "CustomerData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", orders=" + orders +
                '}';
    }
}
