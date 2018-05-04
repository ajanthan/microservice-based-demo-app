package com.github.ajanthan.tracing.spring.web.tracingdemo.model;

public class OrderDetails {

    private Long Id;
    private Long productId;
    private int quantity;

    public OrderDetails(Long productId, int quantity) {

        this.productId = productId;
        this.quantity = quantity;
    }

    private Order order;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
            "Id=" + Id +
            ", productId=" + productId +
            ", quantity=" + quantity +
            ", order=" + order +
            '}';
    }
}
