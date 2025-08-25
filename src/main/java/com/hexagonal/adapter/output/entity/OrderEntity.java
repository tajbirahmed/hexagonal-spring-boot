package com.hexagonal.adapter.output.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name = "orders") @Data @AllArgsConstructor @NoArgsConstructor @Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String customerName;
    private String item;
    private Long quantity;
    private String status;

}
