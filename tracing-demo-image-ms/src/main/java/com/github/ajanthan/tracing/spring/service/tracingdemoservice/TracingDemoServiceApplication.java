package com.github.ajanthan.tracing.spring.service.tracingdemoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TracingDemoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TracingDemoServiceApplication.class, args);
	}
}
