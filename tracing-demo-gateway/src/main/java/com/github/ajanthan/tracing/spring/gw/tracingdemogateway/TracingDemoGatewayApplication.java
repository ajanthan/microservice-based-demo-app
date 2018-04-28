package com.github.ajanthan.tracing.spring.gw.tracingdemogateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class TracingDemoGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TracingDemoGatewayApplication.class, args);
    }
}
