package org.russow.service.impl;

import org.russow.model.Order;
import org.russow.model.OrderStatus;
import org.russow.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class OrderServiceImpl implements OrderService<Order> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public boolean addOrder(Order order) {
        boolean result;

        OrderStatus orderStatus = new OrderStatus(1, "order processing");
        order.setStatus(orderStatus);

        entityManager.persist(order);

        result = true;

        return result;
    }
}
