package com.scaler.paymentapplication.Services;

import com.razorpay.RazorpayException;

public interface PaymentService {

    public String createPaymentLink(String orderId, double amount) throws RazorpayException;

    public void getPaymentStatus(String orderId);

}
