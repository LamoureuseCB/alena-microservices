package com.practice.orderservice;

import com.practice.paymentservice.Payment;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "orders")
public class Order {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int id;
       private String user;
       private String address;
       @OneToOne
       @JoinColumn(name = "payment_id", nullable = false)
       private Payment payment;

}
