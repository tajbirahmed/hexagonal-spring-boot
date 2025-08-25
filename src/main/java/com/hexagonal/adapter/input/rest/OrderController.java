package com.hexagonal.adapter.input.rest;

import com.hexagonal.domain.dto.request.PlaceOrderRequest;
import com.hexagonal.domain.dto.request.TrackOrderRequest;
import com.hexagonal.domain.dto.response.TrackOrderResponse;
import com.hexagonal.domain.port.input.PlaceOrderUseCase;
import com.hexagonal.domain.port.input.TrackOrderUseCase;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Schema(name = "Order", description = "Order API")
@Tag(name = "Order", description = "Order API")
public class OrderController {
    private final PlaceOrderUseCase placeOrderUseCase;
    private final TrackOrderUseCase trackOrderUseCase;

    @Schema(name = "Place Order", description = "Place a new order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order placed successfully"),
    })
    @PostMapping
    public Mono<ResponseEntity<Void>> placeOrder(
            @Valid @RequestBody PlaceOrderRequest request
    ) {
        return Mono.fromRunnable(() -> placeOrderUseCase.placeOrder(request))
                .then(Mono.just(ResponseEntity.ok().build()));
    }

    @Schema(name = "Track Order", description = "Track an existing order by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order tracked successfully"),
            @ApiResponse(responseCode = "404", description = "Order not found"),
    })
    @GetMapping("/{orderId}")
    public Mono<ResponseEntity<TrackOrderResponse>> trackOrder(
            @Valid @PathVariable Long orderId
    ) {
        TrackOrderResponse trackOrderResponse = trackOrderUseCase.trackOrder(new TrackOrderRequest(orderId));
        return Mono.just(ResponseEntity.ok(trackOrderResponse));
    }
}
