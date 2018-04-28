package com.github.ajanthan.tracing.spring.service.tracingdemoservice.service;


import com.github.ajanthan.tracing.spring.service.tracingdemoservice.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@RestController
@RequestMapping(value = "/product")
public class ProductService {


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity addProduct(Product product) {
        RestTemplate restTemplate = new RestTemplate();
        URI productServiceURL = null;
        try {
            productServiceURL = new URL("http://localhost:8081/product/").toURI();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        restTemplate.postForObject(productServiceURL, product, Product.class);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }


    @RequestMapping(value = "/{productID}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable("productID") Long productID) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Product> product = restTemplate.getForEntity("http://localhost:8081/product/" + productID, Product.class);
        // Optional<Product> product = repository.findById(productID);

        if (product.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok(product.getBody());
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Iterable> product = restTemplate.getForEntity("http://localhost:8081/product/", Iterable.class);
        // Optional<Product> product = repository.findById(productID);

        if (product.getStatusCode() == HttpStatus.OK) {
            return product.getBody();
        }
        return null;
    }
}
