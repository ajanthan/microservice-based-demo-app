package com.github.ajanthan.tracing.spring.web.tracingdemo.model;


import java.util.List;
import java.util.Map;

public class Product {

    private Long id;
    private String name;
    private String description;
    private double price;
    private String[] tags;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public static Product getObject(Map<String, Object> map) {
        Product product = new Product();
        product.setId(Long.parseLong(map.get("id").toString()));
        product.setName(map.get("name").toString());
        product.setDescription(map.get("description").toString());
        product.setPrice(Double.parseDouble(map.get("price").toString()));
        List<String> tagMap = (List<String>) map.get("tags");

        product.setTags(tagMap.toArray(new String[0]));

        return product;
    }
}
