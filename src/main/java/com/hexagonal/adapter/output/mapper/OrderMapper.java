package com.hexagonal.adapter.output.mapper;

import com.hexagonal.adapter.output.entity.OrderEntity;
import com.hexagonal.domain.dto.request.PlaceOrderRequest;
import com.hexagonal.domain.dto.response.TrackOrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "id", ignore = true)
    OrderEntity toEntity(PlaceOrderRequest r);

    TrackOrderResponse toResponse(OrderEntity order);
}
