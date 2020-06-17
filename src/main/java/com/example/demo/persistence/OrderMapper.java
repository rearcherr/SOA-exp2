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
    void insertLineItem(LineItem lineItem);

    Order getOrder(int orderId);
    LineItem getLineItem(int orderId,int lineNumber);
    void insertOrderStatus(Order order);
    List<LineItem> getLineItemList(int orderId);
    List<Order> getOrderList();
    void updateOrder(Order order);
    void updateOrderStatus(Order order);
    void updateLineItem(LineItem lineItem);
    void deleteLineItemList(int orderId);
    void deleteOrder(int orderId);
    void deleteOrderStatus(int orderId);
    void deleteLineItem(int orderId,int linenum);
    List<Order> getOrderListByShipAddress1(String shipAddress1);
    List<Order> getOrderListByShipAddress2(String shipAddress2);
    List<Order> getOrderListByBillAddress1(String billAddress1);
    List<Order> getOrderListByBillAddress2(String billAddress2);
    List<Order> getOrderListByShipToFirstName(String shipToFirstName);
    List<Order> getOrderListByBillToFirstName(String billToFirstName);
    List<Order> getOrderListByStatus(String status);
}
