package com.example.demo.service;

import com.example.demo.domain.Order;
import com.example.demo.persistence.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getOrderListByUsername(String username){
        return orderMapper.getOrderListByUsername(username);
    }

    public Order getOrder(int orderId) {
        return orderMapper.getOrder(orderId);
    }

    public void insertOrder(Order order){
        orderMapper.insertOrder(order);
    }

    public void insertOrderStatus(Order order){
        orderMapper.insertOrderStatus(order);
    }
}