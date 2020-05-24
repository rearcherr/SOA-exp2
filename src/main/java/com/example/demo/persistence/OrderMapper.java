package com.example.demo.persistence;

import com.example.demo.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {


    List<Order> getOrderListByUsername(String username);

    void insertOrder(Order order);

    Order getOrder(int orderId);

    void insertOrderStatus(Order order);
}
