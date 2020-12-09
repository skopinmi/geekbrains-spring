package com.geekbrains.spring.lesson6.entities.views;

public final class OrderView extends CommonView {

    public interface IdCode extends CommonFull{}
    public interface IdCodePriceCustomer extends CommonFull, CustomerView.IdName{}
    public interface IdCodeCustomerOrderEntry extends IdCodePriceCustomer, OrderEntryView.Entry{}

}