package com.github.ajanthan.tracing.spring.web.tracingdemo.controller;

import com.github.ajanthan.tracing.spring.web.tracingdemo.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class ListProductsController {
    @GetMapping("/")
    public String getAllProducts(Model model) {
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
        List<Product> productList = new ArrayList<>();

        while (productIterator.hasNext()) {
            Map<String, Object> product = (Map<String, Object>) productIterator.next();
            productList.add(Product.getObject(product));
        }


        //products.forEach(product -> productList.add((Product) product));
        System.out.println("Product List " + productList);
        model.addAttribute("products", productList);

        return "index";
    }
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
}
