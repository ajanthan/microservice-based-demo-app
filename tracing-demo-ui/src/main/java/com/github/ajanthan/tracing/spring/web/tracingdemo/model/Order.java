package com.github.ajanthan.tracing.spring.web.tracingdemo.model;

import java.util.List;
import java.util.Map;


public class Order {

    private Long Id;

    private String userId;

    public List<OrderDetails> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDetails> orders) {
        this.orders = orders;
    }

    private List<OrderDetails> orders;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
            "Id=" + Id +
            ", userId='" + userId + '\'' +
            ", orderDetails=" + orders +
            '}';
    }

    public Order(String userId) {
        this.userId = userId;
    }

    public static Order getObject(Map<String, Object> map) {
        Order order = new Order();
        order.setId(Long.parseLong(map.get("id").toString()));

        return order;
    }
}
