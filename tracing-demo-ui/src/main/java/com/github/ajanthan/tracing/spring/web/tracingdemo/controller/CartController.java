package com.github.ajanthan.tracing.spring.web.tracingdemo.controller;

import com.github.ajanthan.tracing.spring.web.tracingdemo.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.nio.file.attribute.UserPrincipal;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("cart", cartService.getOrderMap());
        return "cart";
    }

    @PostMapping("/cart/{productId}")
    public void addToCart(@PathVariable("productId") String productIdStr) {
        Long productId = Long.getLong(productIdStr);
        cartService.addToCart(productId);
    }

    @PostMapping("/cart/{productId}/{quantity}")
    public void updateCart(@PathVariable("productId") String productIdStr,
                           @PathVariable("quantity") String quantitystr) {
        Long productId = Long.getLong(productIdStr);
        int quantity = Integer.getInteger(quantitystr);
        cartService.updateCart(productId, quantity);
    }

    @PostMapping("/cart")
    public void checkout(UserPrincipal principal) {
        cartService.checkout(principal.getName());
    }
}
