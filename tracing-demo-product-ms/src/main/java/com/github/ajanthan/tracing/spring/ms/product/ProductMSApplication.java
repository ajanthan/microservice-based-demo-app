package com.github.ajanthan.tracing.spring.ms.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductMSApplication {

    public static void main(String[] args) {

        SpringApplication.run(ProductMSApplication.class, args);
    }
}
