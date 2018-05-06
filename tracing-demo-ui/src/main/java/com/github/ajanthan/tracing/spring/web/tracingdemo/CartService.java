package com.github.ajanthan.tracing.spring.web.tracingdemo;

import com.github.ajanthan.tracing.spring.web.tracingdemo.model.Order;
import com.github.ajanthan.tracing.spring.web.tracingdemo.model.OrderDetails;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartService {

    private Map<Long, Integer> orderMap = new HashMap<>();

    public void addToCart(Long productId) {
        if (orderMap.get(productId) != null) {
            int orderQuantity = orderMap.get(productId).intValue();
            orderQuantity++;
            orderMap.put(productId, orderQuantity);
        } else {
            orderMap.put(productId, 1);
        }
    }

    public void updateCart(Long productId, int quantity) {
        orderMap.put(productId, quantity);
    }

    public void checkout(String userid) {
        RestTemplate orderClient = new RestTemplate();
        Order order = new Order(userid);
        List<OrderDetails> orderDetails = new ArrayList<>();
        for (Long porductId : orderMap.keySet()) {
            orderDetails.add(new OrderDetails(porductId, orderMap.get(porductId)));
        }
        order.setOrders(orderDetails);

        ResponseEntity<String> responseEntity = orderClient.postForEntity("http://localhost:8084/order/", order, String.class);
        orderMap.clear();
    }

    public Map<Long, Integer> getOrderMap() {
        return orderMap;
    }
}
