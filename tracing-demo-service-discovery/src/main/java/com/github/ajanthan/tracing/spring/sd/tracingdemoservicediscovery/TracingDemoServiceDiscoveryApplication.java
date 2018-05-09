package com.github.ajanthan.tracing.spring.sd.tracingdemoservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TracingDemoServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TracingDemoServiceDiscoveryApplication.class, args);
	}
}
