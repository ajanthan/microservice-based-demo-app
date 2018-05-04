package com.github.ajanthan.tracing.spring.web.tracingdemo.model;

import java.util.List;


public class Order {

    private Long Id;

    private String userId;

    private List<OrderDetails> orderDetails;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
            "Id=" + Id +
            ", userId='" + userId + '\'' +
            ", orderDetails=" + orderDetails +
            '}';
    }

    public Order(String userId) {
        this.userId = userId;
    }
}
