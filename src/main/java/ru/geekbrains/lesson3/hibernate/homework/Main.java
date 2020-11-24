package ru.geekbrains.lesson3.hibernate.homework;

import org.hibernate.cfg.Configuration;
import ru.geekbrains.lesson3.hibernate.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
        EntityManager em = factory.createEntityManager();

        clear(em);

        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            Customer customerF = new Customer("Fox");
            Customer customerW = new Customer("Wolf");

            Product product1 = new Product("Ship", 100.0);
            Product product2 = new Product("Rabbit", 30.5);
            Product product3 = new Product("Cow", 500.0);


            List<Product> productList1 = new ArrayList<>();
            productList1.add(product1);
            productList1.add(product2);

            List<Product> productList2 = new ArrayList<>();
            productList2.add(product2);
            productList2.add(product3);

            customerF.setProducts(productList1);
            customerW.setProducts(productList2);

            product1.addCustomers(customerF);
            product2.addCustomers(customerF);
            product2.addCustomers(customerW);
            product3.addCustomers(customerW);

            em.persist(customerF);
            em.persist(customerW);

            transaction.commit();

// просмотр товаров клиента - работает

            Customer one = em.find(Customer.class, customerF.getId());
            System.out.println(one);
            System.out.println("Products: ");
            for (Product p : one.getProducts()) {
                System.out.println(p.getTitle());
            }

            Customer two = em.find(Customer.class, customerW.getId());
            System.out.println(two);
            System.out.println("Products: ");
            for (Product p : two.getProducts()) {
                System.out.println(p.getTitle());
            }

//            просмотр клиентов купивших товар - работает

            Product productTest = em.find(Product.class, product1.getId());
            System.out.println(productTest.getTitle() + " купили : ");
            for (Customer c : productTest.getCustomers()) {
                System.out.println(c.getName());
            }

//             удаление из базы - какая то ошибка, просто в базе 

            transaction.begin();
            String idP = product1.getId().toString();
            System.out.println(idP);
            em.createQuery("DELETE FROM product WHERE id = " + idP).executeUpdate();

            String idC = customerF.getId().toString();
            em.createQuery("DELETE FROM customer WHERE id = " + idC).executeUpdate();
            transaction.commit();


        } finally {
            factory.close();
            if (em != null) {
                em.close();
            }
        }
    }

    private static void clear(EntityManager em) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Customer").executeUpdate();
        em.createQuery("DELETE FROM Product").executeUpdate();
        em.getTransaction().commit();
    }
}
