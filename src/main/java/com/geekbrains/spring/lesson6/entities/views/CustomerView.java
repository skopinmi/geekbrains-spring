package com.geekbrains.spring.lesson6.entities.views;

public final class CustomerView extends CommonView {

    public interface IdName extends CommonFull{}
    public interface IdNameBirthday extends IdName{}
    public interface IdNameEmailPhone extends IdName {}
    public interface IdNameBirthdayEmailPhone extends IdNameBirthday, IdNameEmailPhone {}
    public interface IdNameEmailPhoneOrders extends IdNameBirthdayEmailPhone{}

}
