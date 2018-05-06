package com.github.ajanthan.tracing.spring.web.tracingdemo.model;

public class CartItem {
    private String name;
    private Long id;

    public CartItem(String name, Long id, int quantity) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
