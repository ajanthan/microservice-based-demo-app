package com.github.ajanthan.tracing.spring.ms.order.repo;


import com.github.ajanthan.tracing.spring.ms.order.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    @Query("SELECT Order FROM PRODUCT_ORDER Order WHERE Order.userId=:userId")
    Iterable<Order> getOrderOfUser(@Param("userId") String userId);
}
