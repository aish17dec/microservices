package com.example.customerservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Order {

    private int order_id;

    private int customer_id;
    private Date order_date;
    private int status;
    private String comments;
    private Date shipped_date;
    private int shipper_id;
}
