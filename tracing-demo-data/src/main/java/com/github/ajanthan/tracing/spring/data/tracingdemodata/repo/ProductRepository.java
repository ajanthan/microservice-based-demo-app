package com.github.ajanthan.tracing.spring.data.tracingdemodata.repo;


import com.github.ajanthan.tracing.spring.data.tracingdemodata.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
