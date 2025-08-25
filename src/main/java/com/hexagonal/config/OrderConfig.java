package com.hexagonal.config;

import com.hexagonal.domain.port.output.OrderRepositoryPort;
import com.hexagonal.domain.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Bean
    public OrderService orderService(OrderRepositoryPort orderRepositoryPort) {
        return new OrderService(orderRepositoryPort);
    }
}
