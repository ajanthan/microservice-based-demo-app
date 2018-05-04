package com.github.ajanthan.tracing.spring.ms.order.service;


import com.github.ajanthan.tracing.spring.ms.order.model.Order;
import com.github.ajanthan.tracing.spring.ms.order.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/order")
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity addOrder(@RequestBody Order order) {
//       order.setCount(10);
//       order.setProductId(1L);
//       order.setUserId("2e334");
        System.out.println("Order "+order);
        repository.save(order);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }


    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public ResponseEntity<Order> getOrdertById(@PathVariable("orderId") Long productID) {
        Optional<Order> order = repository.findById(productID);
//        if (!order.isPresent()) {
//            throw new ProductNotFoundException("product[" + productID + "] not found");
//        }
        return ResponseEntity.ok(order.get());

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Order> getAllOrders() {
        return repository.findAll();
    }

    @RequestMapping(value = "/user/{userId}")
    public Iterable<com.github.ajanthan.tracing.spring.ms.order.model.Order> getOrderOfUser(@PathVariable("userId") String userId){
        return repository.getOrderOfUser(userId);
    }
}
