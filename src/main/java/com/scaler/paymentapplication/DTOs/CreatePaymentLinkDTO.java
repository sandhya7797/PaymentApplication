package com.scaler.paymentapplication.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentLinkDTO {

    private String orderId;
    private Integer amount;
}
