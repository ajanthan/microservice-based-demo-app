package com.github.ajanthan.tracing.spring.web.tracingdemo.controller;

import com.github.ajanthan.tracing.spring.web.tracingdemo.CartService;
import com.github.ajanthan.tracing.spring.web.tracingdemo.model.CartItem;
import com.github.ajanthan.tracing.spring.web.tracingdemo.model.Order;
import com.github.ajanthan.tracing.spring.web.tracingdemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

@Controller
public class ListProductsController {
    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public String getAllProducts(Model model, Authentication authentication) {
        UserDetails details = (UserDetails) authentication.getPrincipal();
        RestTemplate restTemplate = new RestTemplate();
        Iterable products = null;
        try {
            products = restTemplate.getForEntity(new URL("http://localhost:8081/product/").toURI(), Iterable.class).getBody();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Iterator productIterator = products.iterator();
        Map<Long, Product> productList = new HashMap<>();

        while (productIterator.hasNext()) {
            Map<String, Object> product = (Map<String, Object>) productIterator.next();
            Product p = Product.getObject(product);
            productList.put(p.getId(), p);
        }
        Map<Long, Integer> cartMap = cartService.getOrderMap();
        List<CartItem> cartItems = new ArrayList<>();
        for (Long pId : cartMap.keySet()) {
            cartItems.add(new CartItem(productList.get(pId).getName(), pId, cartMap.get(pId)));
        }

        Iterator orderItems = restTemplate.getForEntity("http://localhost:8084/order/user/" + details.getUsername(), Iterable.class).getBody().iterator();

        List<Order> orders = new ArrayList<>();

        while (orderItems.hasNext()) {
            Map<String, Object> order = (Map<String, Object>) orderItems.next();
            Order o = Order.getObject(order);
            orders.add(o);
        }

        //products.forEach(product -> productList.add((Product) product));
        System.out.println("Product List " + productList);
        model.addAttribute("products", productList.values());
        model.addAttribute("cart", cartItems);
        model.addAttribute("orderList", orders);

        return "index";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }
}
