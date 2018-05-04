package com.github.ajanthan.tracing.spring.ms.order.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "PRODUCT_ORDER")
@Entity(name = "PRODUCT_ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    @JsonProperty("orderId")
    private Long Id;
    @NotNull
    private String userId;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonProperty("orders")
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

    @PrePersist
    @PreUpdate
    public void updateOrderDetails() {
        this.getOrderDetails().forEach(orderDetails -> {
            orderDetails.setOrder(this);
        });
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
}
