package com.hexagonal.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class PlaceOrderRequest {
    private String name;
    private String customerName;
    private String address;
    private Long quantity;
}
