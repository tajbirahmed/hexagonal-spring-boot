package com.hexagonal.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class TrackOrderResponse {

    private Long id;
    private String name;
    private String customerName;
    private String address;
    private Long quantity;
    private String status;
}
