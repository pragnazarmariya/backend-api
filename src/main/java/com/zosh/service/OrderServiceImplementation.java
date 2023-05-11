package com.zosh.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zosh.modal.Address;
import com.zosh.modal.Cart;
import com.zosh.modal.CartItem;
import com.zosh.modal.Order;
import com.zosh.modal.User;
import com.zosh.repository.OrderRepository;
import com.zosh.user.domain.OrderStatus;
import com.zosh.user.domain.PaymentStatus;

@Service
public class OrderServiceImplementation implements OrderService {
	
	private OrderRepository orderRepository;
	private CartService cartService;
	
	public OrderServiceImplementation(OrderRepository orderRepository,CartService cartService) {
		this.orderRepository=orderRepository;
		this.cartService=cartService;
	}

	@Override
	public Order createOrder(User user,Address shippAddress) {
		
		Cart cart=cartService.findUserCart(user.getId());
		List<CartItem> orderItems=new ArrayList<>(cart.getCartItems());
		
		Order createdOrder=new Order();
		createdOrder.setUser(user);
		createdOrder.setOrderItems(orderItems);
		createdOrder.setTotalPrice(cart.getTotalPrice());
		
		createdOrder.setShippingAddress(shippAddress);
		createdOrder.setOrderDate(LocalDateTime.now());
		createdOrder.setOrderStatus(OrderStatus.PENDING);
		createdOrder.getPaymentDetails().setStatus(PaymentStatus.PENDING);
		
		return orderRepository.save(createdOrder);
		
	}

}
