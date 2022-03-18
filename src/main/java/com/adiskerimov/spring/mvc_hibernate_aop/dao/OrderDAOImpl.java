package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Employee;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Order> getAllOrders() {
        Session session = sessionFactory.getCurrentSession();

        Query<Order> query = session.createQuery("from Order", Order.class);
        List<Order> allOrders = query.getResultList();

        return allOrders;
    }

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
    }
}
