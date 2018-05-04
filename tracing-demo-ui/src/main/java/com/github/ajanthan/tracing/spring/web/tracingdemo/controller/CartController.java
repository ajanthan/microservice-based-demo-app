package com.github.ajanthan.tracing.spring.web.tracingdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class CartController {
    public String getCart(Model model){
        return "cart";
    }
    public void addToCart(String productId){

    }
    public void checkout(){

    }
}
