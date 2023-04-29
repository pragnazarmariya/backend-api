package com.zosh.controller;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.modal.Order;
import com.zosh.service.OrderService;

import com.razorpay.Payment;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	private OrderService orderService;
	
	public PaymentController(OrderService orderService) {
		this.orderService=orderService;
	}
	
	@PostMapping
	public ResponseEntity<String>createPaymentLink(@RequestBody Order order){
		
		Order createdOrder = orderService.createOrder(order);
		 try {
		      // Instantiate a Razorpay client with your key ID and secret
		      RazorpayClient razorpay = new RazorpayClient("rzp_test_kTsRSaDC8hwztX", "LieoD1s9mxMIv569PcgRDMcU");

		      // Create a JSON object with the payment link request parameters
		      JSONObject paymentLinkRequest = new JSONObject();
		      paymentLinkRequest.put("amount",createdOrder.getTotalPrice()* 100);
		      paymentLinkRequest.put("currency","INR");    
		      paymentLinkRequest.put("expire_by",1691097057);
		      paymentLinkRequest.put("reference_id",createdOrder.getId());
		     

		      // Create a JSON object with the customer details
		      JSONObject customer = new JSONObject();
		      customer.put("name",createdOrder.getUser().getFirstName()+" "+createdOrder.getUser().getLastName());
		      customer.put("contact",createdOrder.getUser().getMobile());
		      customer.put("email",createdOrder.getUser().getEmail());
		      paymentLinkRequest.put("customer",customer);

		      // Create a JSON object with the notification settings
		      JSONObject notify = new JSONObject();
		      notify.put("sms",true);
		      notify.put("email",true);
		      paymentLinkRequest.put("notify",notify);

		      // Set the reminder settings
		      paymentLinkRequest.put("reminder_enable",true);

		      // Set the callback URL and method
		      paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
		      paymentLinkRequest.put("callback_method","get");

		      // Create the payment link using the paymentLink.create() method
		      PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);

		      // Print the payment link ID and URL
		      System.out.println("Payment link ID: " + payment.get("id"));
		      System.out.println("Payment link URL: " + payment.get("short_url"));
		    } catch (RazorpayException e) {
		      System.out.println("Error creating payment link: " + e.getMessage());
		    }
		
		return null;
		
	}

}
