package com.zosh.modal;

import com.zosh.user.domain.PaymentMethod;
import com.zosh.user.domain.PaymentStatus;

public class PaymentDetails {
	
	private PaymentMethod paymentMethod;
	private String paymentId;
	private PaymentStatus status;
	
	public PaymentDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public PaymentStatus getStatus() {
		return status;
	}
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	
	

}
