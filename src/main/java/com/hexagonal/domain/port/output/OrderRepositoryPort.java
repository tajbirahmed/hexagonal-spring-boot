package com.hexagonal.domain.port.output;

import com.hexagonal.domain.dto.request.PlaceOrderRequest;
import com.hexagonal.domain.dto.response.TrackOrderResponse;

public interface OrderRepositoryPort {

    void saveOrder(PlaceOrderRequest r);

    TrackOrderResponse findById(Long id);
}
