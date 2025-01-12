package com.practice.orderservice;

import com.practice.paymentservice.Payment;
import com.practice.paymentservice.PaymentRepository;
import com.practice.paymentservice.PaymentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    public Order create(Order order) {
        Payment payment = new Payment();
        payment.setPaid(false);
        payment.setCreated(LocalDateTime.now());
        paymentService.create(payment);
        order.setPayment(payment);
       return orderRepository.save(order);
    }


    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
