package com.github.ajanthan.tracing.spring.ms.product.repo;


import com.github.ajanthan.tracing.spring.ms.product.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
