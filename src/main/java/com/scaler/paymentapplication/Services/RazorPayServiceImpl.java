package com.scaler.paymentapplication.Services;


import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class RazorPayServiceImpl implements PaymentService {

    private RazorpayClient razorpayClient;

    @Autowired
    public RazorPayServiceImpl(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String createPaymentLink(String orderId, double amount) throws RazorpayException {

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",amount);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",true);
        paymentLinkRequest.put("first_min_partial_amount",100);

        // each mint has 60 seconds and each second has 1000 milliseconds
        paymentLinkRequest.put("expire_by", (System.currentTimeMillis() + 15 * 60 * 1000));


        paymentLinkRequest.put("reference_id",orderId);

        paymentLinkRequest.put("description","Payment for order id: " + orderId);

        JSONObject customer = new JSONObject();
        customer.put("name","+919999999999");
        customer.put("contact","Gaurav Kumar");
        customer.put("email","gaurav.kumar@example.com");
        paymentLinkRequest.put("customer",customer);

        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("reminder_enable",true);

        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://www.scaler.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);

        return payment.get("short_url");

    }


    //Call BACK API
    @Override
    public void getPaymentStatus(String orderId) {
        System.out.println("Payment status for order id: " + orderId + " is success");
    }

    //Implement Reconsilation 
}
