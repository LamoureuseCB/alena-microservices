package com.practice.orderservice;

import com.practice.paymentservice.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public Order create(Order order) {
        Payment payment = new Payment();
        payment.setPaid(false);
        payment.setCreated(LocalDateTime.now());
        order.setPayment(payment);
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
