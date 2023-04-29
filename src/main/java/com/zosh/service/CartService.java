package com.zosh.service;

import com.zosh.modal.Cart;
import com.zosh.modal.CartItem;

public interface CartService {
	
	public Cart createCart(Cart cart);
	
	public String addCartItem(Long userId,CartItem cartItem);

}
