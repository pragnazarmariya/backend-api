package com.zosh.service;

import com.zosh.modal.Address;
import com.zosh.modal.Order;
import com.zosh.modal.User;

public interface OrderService {
	
	public Order createOrder(User user, Address shippingAdress);
	
}
