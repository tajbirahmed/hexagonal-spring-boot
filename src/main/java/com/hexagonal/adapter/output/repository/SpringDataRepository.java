package com.hexagonal.adapter.output.repository;


import com.hexagonal.adapter.output.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRepository extends JpaRepository<OrderEntity, Long> {
}
