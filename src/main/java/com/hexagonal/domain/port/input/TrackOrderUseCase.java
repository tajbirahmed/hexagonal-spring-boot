package com.hexagonal.domain.port.input;

import com.hexagonal.domain.dto.request.TrackOrderRequest;
import com.hexagonal.domain.dto.response.TrackOrderResponse;

public interface TrackOrderUseCase {

    TrackOrderResponse trackOrder(TrackOrderRequest r);
}
