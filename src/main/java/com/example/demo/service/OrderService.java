package com.example.demo.service;

import com.example.demo.domain.Account;
import com.example.demo.domain.LineItem;
import com.example.demo.domain.Order;
import com.example.demo.persistence.OrderMapper;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getOrderListByUsername(String username){
        return orderMapper.getOrderListByUsername(username);
    }

    public Order getOrder(int orderId) {
        Order order = orderMapper.getOrder(orderId);
        List<LineItem> lineItems = orderMapper.getLineItemList(orderId);
        order.setLineItems(lineItems);

        return order;
    }

    public void insertOrder(Order order){
        orderMapper.insertOrder(order);
    }

    public List<Order> getOrderList(){
        List<Order> orderList = orderMapper.getOrderList();
        List<Order> orderList1 = new ArrayList<Order>();
        int a = orderList.size();
        Order o ;

        for (int i=0;i<a;i++){
            o=orderList.get(i);
            o.setLineItems(orderMapper.getLineItemList(o.getOrderId()));
            orderList1.add(o);
        }
        return orderList1;
    }



    public void insertOrderStatus(Order order){
        orderMapper.insertOrderStatus(order);
    }

    public void updateOrder(Order order){
        orderMapper.updateOrder(order);
        orderMapper.updateOrderStatus(order);
    }

}