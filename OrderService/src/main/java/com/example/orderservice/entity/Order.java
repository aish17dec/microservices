package com.example.orderservice.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;
    @Column(name = "customer_id")
    private Integer customerId;
    private Date order_date;
    private Integer status;
    @Column(nullable = true)
    private String comments;
    @Column(nullable = true)
    private Date shipped_date;
    @Column(nullable = true)
    private Integer shipper_id;
}
