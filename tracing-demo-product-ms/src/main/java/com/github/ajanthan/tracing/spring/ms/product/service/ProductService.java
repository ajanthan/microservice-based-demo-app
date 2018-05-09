package com.github.ajanthan.tracing.spring.ms.product.service;

import com.github.ajanthan.tracing.spring.ms.product.model.Product;
import com.github.ajanthan.tracing.spring.ms.product.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity addProduct(Product product) {
        repository.save(product);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }


    @RequestMapping(value = "/{productID}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable("productID") Long productID) {
        Optional<Product> product = repository.findById(productID);
        if (!product.isPresent()) {
            throw new ProductNotFoundException("product[" + productID + "] not found");
        }
        return ResponseEntity.ok(product.get());

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Product> getAllProducts() {
        return repository.findAll();
    }
}
