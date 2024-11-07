package com.scaler.paymentapplication.Controllers;


import com.razorpay.RazorpayException;
import com.scaler.paymentapplication.DTOs.CreatePaymentLinkDTO;
import com.scaler.paymentapplication.Services.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/initiate")
    public ResponseEntity<String> createPaymentLink(@RequestBody CreatePaymentLinkDTO createPaymentLinkDTO) throws RazorpayException {
        String response = paymentService.createPaymentLink(createPaymentLinkDTO.getOrderId(), createPaymentLinkDTO.getAmount());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
