package com.hexagonal.domain.service;


import com.hexagonal.domain.dto.request.PlaceOrderRequest;
import com.hexagonal.domain.dto.request.TrackOrderRequest;
import com.hexagonal.domain.dto.response.TrackOrderResponse;
import com.hexagonal.domain.port.input.PlaceOrderUseCase;
import com.hexagonal.domain.port.input.TrackOrderUseCase;
import com.hexagonal.domain.port.output.OrderRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderService implements PlaceOrderUseCase, TrackOrderUseCase {
    private final OrderRepositoryPort orderRepositoryPort;

    @Override
    public void placeOrder(PlaceOrderRequest r) {
        orderRepositoryPort.saveOrder(r);
    }

    @Override
    public TrackOrderResponse trackOrder(TrackOrderRequest r) {
        return orderRepositoryPort.findById(r.getId());
    }
}
