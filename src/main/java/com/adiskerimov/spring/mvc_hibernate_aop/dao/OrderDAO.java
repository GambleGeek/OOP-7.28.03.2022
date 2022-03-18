package com.adiskerimov.spring.mvc_hibernate_aop.dao;

import com.adiskerimov.spring.mvc_hibernate_aop.entity.Order;
import com.adiskerimov.spring.mvc_hibernate_aop.entity.Position;

import java.util.List;

public interface OrderDAO {

    public List<Order> getAllOrders();

    public void saveOrder(Order order);
}
