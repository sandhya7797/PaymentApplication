package com.scaler.paymentapplication.Services;

import org.springframework.stereotype.Service;

@Service
public class StripeServiceImpl implements PaymentService {

    @Override
    public String createPaymentLink(String orderId, double amount) {
        System.out.println("Payment link for order id: " + orderId + " is created successfully");

        return orderId;
    }

    @Override
    public void getPaymentStatus(String orderId) {
        System.out.println("Payment status for order id: " + orderId + " is success");
    }
}
