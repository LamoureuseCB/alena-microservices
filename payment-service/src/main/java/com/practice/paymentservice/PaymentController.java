package com.practice.paymentservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;
@PostMapping
public Payment create(@RequestBody Payment payment) {
    return paymentService.create(payment);
}
    @GetMapping
    public List<Payment> getPayments() {
        return paymentService.findAll();
    }

}
