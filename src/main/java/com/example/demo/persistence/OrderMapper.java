package com.example.demo.persistence;

import com.example.demo.domain.Account;
import com.example.demo.domain.LineItem;
import com.example.demo.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {


    List<Order> getOrderListByUsername(String username);

    void insertOrder(Order order);

    Order getOrder(int orderId);
    void insertOrderStatus(Order order);
    List<LineItem> getLineItemList(int orderId);
    List<Order> getOrderList();
    void updateOrder(Order order);
    void updateOrderStatus(Order order);
}
