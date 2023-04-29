package com.zosh.service;

import org.springframework.stereotype.Service;

import com.zosh.modal.CartItem;
import com.zosh.modal.Order;
import com.zosh.repository.OrderRepository;
import com.zosh.user.domain.OrderStatus;
import com.zosh.user.domain.PaymentStatus;

@Service
public class OrderServiceImplementation implements OrderService {
	
	private OrderRepository orderRepository;
	
	public OrderServiceImplementation(OrderRepository orderRepository) {
		this.orderRepository=orderRepository;
	}

	@Override
	public Order createOrder(Order order) {
		
		double totalPrice=0;
		
		for(CartItem cartItem:order.getCartItems()) {
			totalPrice+=cartItem.getPrice();
		}
		
		order.setTotalPrice(totalPrice);
		order.setOrderStatus(OrderStatus.PENDING);
		order.getPaymentDetails().setStatus(PaymentStatus.PENDING);
		
		Order createdOrder=orderRepository.save(order);
		return createdOrder;
	}

}
