package com.hexagonal.adapter.output;

import com.hexagonal.adapter.output.mapper.OrderMapper;
import com.hexagonal.adapter.output.repository.SpringDataRepository;
import com.hexagonal.domain.dto.request.PlaceOrderRequest;
import com.hexagonal.domain.dto.response.TrackOrderResponse;
import com.hexagonal.domain.port.output.OrderRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaOrderRepository implements OrderRepositoryPort {

    private final SpringDataRepository repository;
    private final OrderMapper orderMapper;

    @Override
    public void saveOrder(PlaceOrderRequest r) {
        repository.save(orderMapper.toEntity(r));
    }

    @Override
    public TrackOrderResponse findById(Long id) {
        return orderMapper.toResponse(repository.findById(id).orElseThrow(() -> new RuntimeException("Order not found")));
    }
}
