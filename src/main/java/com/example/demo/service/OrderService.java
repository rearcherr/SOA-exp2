package com.example.demo.service;

import com.example.demo.domain.Account;
import com.example.demo.domain.Item;
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
        order.setLinenum(order.getLineItems().size());

        return order;
    }


    public void insertOrder(Order order){
        orderMapper.insertOrder(order);
        orderMapper.insertOrderStatus(order);
    }
    public void insertLineItem(LineItem lineItem){
        orderMapper.insertLineItem(lineItem);
    }

    public List<Order> getOrderList(){
        List<Order> orderList = orderMapper.getOrderList();
        List<Order> orderList1 = new ArrayList<Order>();
        int a = orderList.size();
        Order o ;

        for (int i=0;i<a;i++){
            o=orderList.get(i);
            o.setLineItems(orderMapper.getLineItemList(o.getOrderId()));
            o.setLinenum(o.getLineItems().size());
            orderList1.add(o);
        }
        return orderList1;
    }

    public List<Order> getOrderListByShipAddress1(String shipAddress1){
        List<Order> orderList = orderMapper.getOrderListByShipAddress1("%" + shipAddress1.toLowerCase() + "%");
        List<Order> orderList1 = new ArrayList<Order>();
        int a = orderList.size();
        Order o ;

        for (int i=0;i<a;i++){
            o=orderList.get(i);
            o.setLineItems(orderMapper.getLineItemList(o.getOrderId()));
            o.setLinenum(o.getLineItems().size());
            orderList1.add(o);
        }
        return orderList1;
    }

    public List<Order> getOrderListByShipAddress2(String shipAddress2){
        List<Order> orderList = orderMapper.getOrderListByShipAddress2("%" + shipAddress2.toLowerCase() + "%");
        List<Order> orderList1 = new ArrayList<Order>();
        int a = orderList.size();
        Order o ;

        for (int i=0;i<a;i++){
            o=orderList.get(i);
            o.setLineItems(orderMapper.getLineItemList(o.getOrderId()));
            o.setLinenum(o.getLineItems().size());
            orderList1.add(o);
        }
        return orderList1;
    }

    public List<Order> getOrderListByBillAddress1(String billAddress1){
        List<Order> orderList = orderMapper.getOrderListByBillAddress1("%" + billAddress1.toLowerCase() + "%");
        List<Order> orderList1 = new ArrayList<Order>();
        int a = orderList.size();
        Order o ;

        for (int i=0;i<a;i++){
            o=orderList.get(i);
            o.setLineItems(orderMapper.getLineItemList(o.getOrderId()));
            o.setLinenum(o.getLineItems().size());
            orderList1.add(o);
        }
        return orderList1;
    }

    public List<Order> getOrderListByBillAddress2(String billAddress2){
        List<Order> orderList = orderMapper.getOrderListByBillAddress2("%" + billAddress2.toLowerCase() + "%");
        List<Order> orderList1 = new ArrayList<Order>();
        int a = orderList.size();
        Order o ;

        for (int i=0;i<a;i++){
            o=orderList.get(i);
            o.setLineItems(orderMapper.getLineItemList(o.getOrderId()));
            o.setLinenum(o.getLineItems().size());
            orderList1.add(o);
        }
        return orderList1;
    }
    public List<Order> getOrderListByShipToFirstName(String shipToFirstName){
        List<Order> orderList = orderMapper.getOrderListByShipToFirstName("%" + shipToFirstName.toLowerCase() + "%");
        List<Order> orderList1 = new ArrayList<Order>();
        int a = orderList.size();
        Order o ;

        for (int i=0;i<a;i++){
            o=orderList.get(i);
            o.setLineItems(orderMapper.getLineItemList(o.getOrderId()));
            o.setLinenum(o.getLineItems().size());
            orderList1.add(o);
        }
        return orderList1;
    }
    public List<Order> getOrderListByBillToFirstName(String billToFirstName){
        List<Order> orderList = orderMapper.getOrderListByBillToFirstName("%" + billToFirstName.toLowerCase() + "%");
        List<Order> orderList1 = new ArrayList<Order>();
        int a = orderList.size();
        Order o ;

        for (int i=0;i<a;i++){
            o=orderList.get(i);
            o.setLineItems(orderMapper.getLineItemList(o.getOrderId()));
            o.setLinenum(o.getLineItems().size());
            orderList1.add(o);
        }
        return orderList1;
    }

    public List<Order> getOrderListByStatus(String status){
        List<Order> orderList = orderMapper.getOrderListByStatus("%" + status.toLowerCase() + "%");
        List<Order> orderList1 = new ArrayList<Order>();
        int a = orderList.size();
        Order o ;

        for (int i=0;i<a;i++){
            o=orderList.get(i);
            o.setLineItems(orderMapper.getLineItemList(o.getOrderId()));
            o.setLinenum(o.getLineItems().size());
            orderList1.add(o);
        }
        return orderList1;
    }

    public LineItem getLineItem(int orderId,int lineNumber){
        LineItem lineItem = orderMapper.getLineItem(orderId,lineNumber);
        return lineItem;
    }


    public void insertOrderStatus(Order order){
        orderMapper.insertOrderStatus(order);
    }

    public void updateOrder(Order order){
        orderMapper.updateOrder(order);
        orderMapper.updateOrderStatus(order);
    }

    public void deleteOrder(int orderId){
        orderMapper.deleteOrder(orderId);
        orderMapper.deleteOrderStatus(orderId);
        orderMapper.deleteLineItemList(orderId);

    }

    public void deleteLineItem(int orderId,int linenum){
        orderMapper.deleteLineItem(orderId,linenum);
    }
    public void updateLineItem(LineItem lineItem){
        orderMapper.updateLineItem(lineItem);
    }

}