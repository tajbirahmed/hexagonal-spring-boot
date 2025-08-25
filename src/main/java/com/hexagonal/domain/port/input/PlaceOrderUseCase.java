package com.hexagonal.domain.port.input;

import com.hexagonal.domain.dto.request.PlaceOrderRequest;

public interface PlaceOrderUseCase {
    void placeOrder(PlaceOrderRequest r);
}
