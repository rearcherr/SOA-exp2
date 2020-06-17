package com.example.demo.controller;


import com.example.demo.domain.*;
import com.example.demo.service.AccountService;
import com.example.demo.service.CatalogService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.Line;
import java.math.BigDecimal;
import java.util.*;

@SessionAttributes({"account", "myList", "authenticated", "cart", "order"})

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CatalogService catalogService;



    //查看所有订单
    @GetMapping("/viewAllOrder")
    @ResponseBody
    public List<Order> viewOrderList() {
        List<Order> order = orderService.getOrderList();
        return order;
    }

    //通过订单号查看订单
    @GetMapping("/viewOrderByOrderId/{id}")
    @ResponseBody
    public Order viewOrderByOrderId(@PathVariable int id) {
        Order order = orderService.getOrder(id);

        return order;
    }

    //通过shipAddress1查看订单
    @GetMapping("/searchOrder/shipAddress1/{id}")
    @ResponseBody
    public List<Order> viewOrderListByShipAddress1(@PathVariable String id) {
        List<Order> orders = orderService.getOrderListByShipAddress1(id);

        return orders;
    }
    //通过shipAddress2查看订单
    @GetMapping("/searchOrder/shipAddress2/{id}")
    @ResponseBody
    public List<Order> viewOrderListByShipAddress2(@PathVariable String id) {
        List<Order> orders = orderService.getOrderListByShipAddress2(id);

        return orders;
    }

    //通过billAddress1查看订单
    @GetMapping("/searchOrder/billAddress1/{id}")
    @ResponseBody
    public List<Order> viewOrderListByBillAddress1(@PathVariable String id) {
        List<Order> orders = orderService.getOrderListByBillAddress1(id);

        return orders;
    }
    //通过billAddress2查看订单
    @GetMapping("/searchOrder/billAddress2/{id}")
    @ResponseBody
    public List<Order> viewOrderListByBillAddress2(@PathVariable String id) {
        List<Order> orders = orderService.getOrderListByBillAddress2(id);

        return orders;
    }
    //通过shipToFirstName查看订单
    @GetMapping("/searchOrder/shipToFirstName/{id}")
    @ResponseBody
    public List<Order> viewOrderListByShipToFirstName(@PathVariable String id) {
        List<Order> orders = orderService.getOrderListByShipToFirstName(id);

        return orders;
    }

    //通过billToFirstName查看订单
    @GetMapping("/searchOrder/billToFirstName/{id}")
    @ResponseBody
    public List<Order> viewOrderListByBillToFirstName(@PathVariable String id) {
        List<Order> orders = orderService.getOrderListByBillToFirstName(id);

        return orders;
    }

    //通过status查看订单
    @GetMapping("/searchOrder/status/{id}")
    @ResponseBody
    public List<Order> viewOrderListByStatus(@PathVariable String id) {
        List<Order> orders = orderService.getOrderListByStatus(id);

        return orders;
    }

    //通过订单号修改订单(lineItems以外的部分）
    @PutMapping("/updateOrder/{id}")
    @ResponseBody
    public void update (@PathVariable("id")int id,@RequestParam(value = "userid", required = false)String username,
                        @RequestParam(value = "orderdate", required = false)Date orderDate,
                        @RequestParam(value = "shipaddr1", required = false)String shipAddress1,
                        @RequestParam(value = "shipaddr2", required = false)String shipAddress2,
                        @RequestParam(value = "shipcity", required = false)String shipCity,
                        @RequestParam(value = "shipstate", required = false)String shipState,
                        @RequestParam(value = "shipzip", required = false)String shipZip,
                        @RequestParam(value = "shipcountry", required = false)String shipCountry,
                        @RequestParam(value = "billaddr1", required = false)String billAddress1,
                        @RequestParam(value = "billaddr2", required = false)String billAddress2,
                        @RequestParam(value = "billcity", required = false)String billCity,
                        @RequestParam(value = "billstate", required = false)String billState,
                        @RequestParam(value = "billzip", required = false)String billZip,
                        @RequestParam(value = "billcountry", required = false)String billCountry,
                        @RequestParam(value = "courier", required = false)String courier,
                        @RequestParam(value = "totalprice", required = false) BigDecimal totalPrice,
                        @RequestParam(value = "billtofirstname", required = false)String billToFirstName,
                        @RequestParam(value = "billtolastname", required = false)String billToLastName,
                        @RequestParam(value = "shiptofirstname", required = false)String shipToFirstName,
                        @RequestParam(value = "shiptolastname", required = false)String shipToLastName,
                        @RequestParam(value = "creditcard", required = false)String creditCard,
                        @RequestParam(value = "exprdate", required = false)String expiryDate,
                        @RequestParam(value = "cardtype", required = false)String cardType,
                        @RequestParam(value = "locale", required = false)String locale,
                        @RequestParam(value = "status", required = false)String status,
                        @RequestParam(value = "linenum", required = false)Integer linenum){
        Order order = orderService.getOrder(id);
        if (username!=null){
            order.setUsername(username);
        }
        if (orderDate!=null){
            order.setOrderDate(orderDate);
        }
        if (shipAddress1!=null){
            order.setShipAddress1(shipAddress1);
        }
        if (shipAddress2!=null){
            order.setShipAddress2(shipAddress2);
        }
        if (shipCity!=null){
            order.setShipCity(shipCity);
        }
        if (shipState!=null){
            order.setShipState(shipState);
        }
        if (shipZip!=null){
            order.setShipZip(shipZip);
        }
        if (shipCountry!=null){
            order.setShipCountry(shipCountry);
        }
        if (billAddress1!=null){
            order.setBillAddress1(billAddress1);
        }
        if (billAddress2!=null){
            order.setBillAddress2(billAddress2);
        }
        if (billCity!=null){
            order.setBillCity(billCity);
        }
        if (billState!=null){
            order.setBillState(billState);
        }
        if (billZip!=null){
            order.setBillZip(billZip);
        }
        if (billCountry!=null){
            order.setBillCountry(billCountry);
        }
        if (courier!=null){
            order.setCourier(courier);
        }
        if (totalPrice!=null){
            order.setTotalPrice(totalPrice);
        }
        if (billToFirstName!=null){
            order.setBillToFirstName(billToFirstName);
        }
        if (billToLastName!=null){
            order.setBillToLastName(billToLastName);
        }
        if (shipToFirstName!=null){
            order.setShipToFirstName(shipToFirstName);
        }
        if (shipToLastName!=null){
            order.setShipToLastName(shipToLastName);
        }
        if (creditCard!=null){
            order.setCreditCard(creditCard);
        }
        if (expiryDate!=null){
            order.setExpiryDate(expiryDate);
        }
        if (cardType!=null){
            order.setCardType(cardType);
        }
        if (status!=null){
            order.setStatus(status);
        }
        if (locale!=null){
            order.setLocale(locale);
        }
        if (linenum!=null){
            order.setLinenum(linenum);
        }
        orderService.updateOrder(order);




    }

    //通过订单号修改lineItem(单个）
    @PutMapping("/updatelineItem/{id}/{linenum}")
    @ResponseBody
    public void update (@PathVariable("id")int id,@PathVariable("linenum")int linenum,
                        @RequestParam(value = "itemid", required = false)String itemId,
                        @RequestParam(value = "quantity", required = false)Integer quantity,
                        @RequestParam(value = "unitprice", required = false)BigDecimal unitPrice){
        LineItem lineItem = orderService.getLineItem(id,linenum);
        if(itemId!=null){
            lineItem.setItemId(itemId);
        }
        if (quantity!=null){
            lineItem.setQuantity(quantity);
        }
        if(unitPrice!=null){
            lineItem.setUnitPrice(unitPrice);
        }
        orderService.updateLineItem(lineItem);
    }

    //新增lineItem(单个)
    @PostMapping("newLineItem")
    @ResponseBody
    public void Creat(@RequestParam("orderid")Integer orderId,
                      @RequestParam("linenum")Integer lineNumber,
                      @RequestParam("itemid")String itemId,
                      @RequestParam("quantity")Integer quantity,
                      @RequestParam("unitprice")BigDecimal unitPrice){
        LineItem lineItem = new LineItem();
        lineItem.setOrderId(orderId);
        lineItem.setLineNumber(lineNumber);
        lineItem.setItemId(itemId);
        lineItem.setQuantity(quantity);
        lineItem.setUnitPrice(unitPrice);
        orderService.insertLineItem(lineItem);
    }

    //删除lineItem(单个)
    @DeleteMapping("/deleteLineItem/{id}/{linenum}")
    @ResponseBody
    public void deleteLineItem(@PathVariable("id")int id,@PathVariable("linenum")int linenum){

        orderService.deleteLineItem(id,linenum);
    }




    //新增Order
    @PostMapping("newOrder")
    @ResponseBody
    public void Creat(@RequestParam(value = "orderid", required = false)int orderId,
                      @RequestParam(value = "userid", required = false)String username,
                      @RequestParam(value = "orderdate", required = false)Date orderDate,
                      @RequestParam(value = "shipaddr1", required = false)String shipAddress1,
                      @RequestParam(value = "shipaddr2", required = false)String shipAddress2,
                      @RequestParam(value = "shipcity", required = false)String shipCity,
                      @RequestParam(value = "shipstate", required = false)String shipState,
                      @RequestParam(value = "shipzip", required = false)String shipZip,
                      @RequestParam(value = "shipcountry", required = false)String shipCountry,
                      @RequestParam(value = "billaddr1", required = false)String billAddress1,
                      @RequestParam(value = "billaddr2", required = false)String billAddress2,
                      @RequestParam(value = "billcity", required = false)String billCity,
                      @RequestParam(value = "billstate", required = false)String billState,
                      @RequestParam(value = "billzip", required = false)String billZip,
                      @RequestParam(value = "billcountry", required = false)String billCountry,
                      @RequestParam(value = "courier", required = false)String courier,
                      @RequestParam(value = "totalprice", required = false) BigDecimal totalPrice,
                      @RequestParam(value = "billtofirstname", required = false)String billToFirstName,
                      @RequestParam(value = "billtolastname", required = false)String billToLastName,
                      @RequestParam(value = "shiptofirstname", required = false)String shipToFirstName,
                      @RequestParam(value = "shiptolastname", required = false)String shipToLastName,
                      @RequestParam(value = "creditcard", required = false)String creditCard,
                      @RequestParam(value = "exprdate", required = false)String expiryDate,
                      @RequestParam(value = "cardtype", required = false)String cardType,
                      @RequestParam(value = "locale", required = false)String locale,
                      @RequestParam(value = "status", required = false)String status,
                      @RequestParam(value = "linenum", required = false)Integer linenum){
        Order order = new Order();
        order.setOrderId(orderId);
        order.setUsername(username);
        order.setOrderDate(orderDate);
        order.setShipAddress1(shipAddress1);
        order.setShipAddress2(shipAddress2);
        order.setShipCity(shipCity);
        order.setShipState(shipState);
        order.setShipZip(shipZip);
        order.setShipCountry(shipCountry);
        order.setBillAddress1(billAddress1);
        order.setBillAddress2(billAddress2);
        order.setBillCity(billCity);
        order.setBillState(billState);
        order.setBillZip(billZip);
        order.setBillCountry(billCountry);
        order.setCourier(courier);
        order.setTotalPrice(totalPrice);
        order.setBillToFirstName(billToFirstName);
        order.setBillToLastName(billToLastName);
        order.setShipToFirstName(shipToFirstName);
        order.setShipToLastName(shipToLastName);
        order.setCreditCard(creditCard);
        order.setExpiryDate(expiryDate);
        order.setCardType(cardType);
        order.setLocale(locale);
        order.setStatus(status);
        order.setLinenum(linenum);

        orderService.insertOrder(order);
    }


    //删除Order
    @DeleteMapping("/deleteOrder/{id}")
    @ResponseBody
    public void deleteOrder(@PathVariable("id")int id){

        orderService.deleteOrder(id);
    }























//
//
//
//    @GetMapping("/viewOrder")
//    public String viewOrder(int orderId, Model model) {
//        Order order = orderService.getOrder(orderId);
//
//        model.addAttribute("order", order);
//        return "order/viewOrder";
//    }
//
//    @GetMapping("/newOrder")
//    public String newOrder(HttpServletRequest request, Model model) {
////        没登录就去登录
//        if (request.getSession().getAttribute("account") == null) {
//            return "account/signon";
//        } else {
//            Cart cart = (Cart) (request.getSession().getAttribute("cart"));
//            Iterator<CartItem> cartItems = cart.getAllCartItems();
//            boolean inStock = true;     //用来标记购物车内是否有商品超出库存了
//            while (cartItems.hasNext()) {
//                CartItem cartItem = cartItems.next();
//                if (cartItem.isInStock() == true) {
//
//                } else {
//                    inStock = false;
//                }
//            }
//
//            if (inStock != true) {
//                return "cart/cart";
//            } else {
//                return "order/newOrderForm";
//            }
//        }
//    }
//
//    @PostMapping("/confirmOrder")
//    public String confirmOrder(HttpServletRequest request, String shipAddr, Model model) {
//        Order order = new Order();
//        //设置一个order入数据库
//        HttpSession session = request.getSession();
//        order.setUsername(((Account) session.getAttribute("account")).getUsername());
//        order.setOrderDate(new Date());
//        order.setBillAddress1((String) request.getParameter("billAddr1"));
//        order.setBillAddress2((String) request.getParameter("billAddr2"));
//        order.setBillCity((String) request.getParameter("billCity"));
//        order.setBillState((String) request.getParameter("billState"));
//        order.setBillZip((String) request.getParameter("billZip"));
//        order.setBillCountry((String) request.getParameter("billCountry"));
//        order.setTotalPrice(((Cart) session.getAttribute("cart")).getSubTotal());
//        order.setBillToFirstName((String) request.getParameter("billFirstName"));
//        order.setBillToLastName((String) request.getParameter("billLastName"));
//        order.setCreditCard((String) request.getParameter("cardNumber"));
//        order.setExpiryDate((String) request.getParameter("exprDate"));
//        order.setCardType((String) request.getParameter("cardType"));
//        order.setLocale("CA");
//        order.setCourier("UPS");
//        order.setShipAddress1((String) request.getParameter("billAddr1"));
//        order.setShipAddress2((String) request.getParameter("billAddr2"));
//        order.setShipCity((String) request.getParameter("billCity"));
//        order.setShipState((String) request.getParameter("billState"));
//        order.setShipZip((String) request.getParameter("billZip"));
//        order.setShipCountry((String) request.getParameter("billCountry"));
//        order.setShipToFirstName((String) request.getParameter("billFirstName"));
//        order.setShipToLastName((String) request.getParameter("billLastName"));
//        order.setStatus("P");
//        session.setAttribute("order", order);
//        model.addAttribute("order", order);
////        if(shipAddr==null){
//
//        return "order/confirmOrder";    //去确认订单
//
//
////        }
////        else{
////
////        }
//    }
//
//
//    @PostMapping("/confirm")
//    public String confirm(HttpServletRequest request, Model model) {
//
//        //将库存数量减去购物车里数量
//        Cart cart = (Cart) (request.getSession().getAttribute("cart"));
//        Iterator<CartItem> cartItems = cart.getAllCartItems();
//        while (cartItems.hasNext()) {
//            CartItem cartItem = cartItems.next();
//            Map<String, Object> param = new HashMap<String, Object>(2);
//            String itemId = cartItem.getItem().getItemId();
//            Integer increment = cartItem.getQuantity();
//            param.put("itemId", itemId);
//            param.put("increment", increment);
//            catalogService.updateInventoryQuantity(param);
//        }
//
//        Order order = (Order) (request.getSession().getAttribute("order"));
//        //将order入库
//        orderService.insertOrder(order);
//        orderService.insertOrderStatus(order);
//        cart.clean();//清空购物车
//
//        return "catalog/main";
//
//    }
//

}
