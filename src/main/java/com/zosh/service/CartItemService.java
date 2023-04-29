package com.zosh.service;

import com.zosh.exception.CartItemException;
import com.zosh.modal.Cart;
import com.zosh.modal.CartItem;
import com.zosh.modal.Product;

public interface CartItemService {
	
	public CartItem createCartItem(CartItem cartItem);
	
	public String updateCartItem(Long id,CartItem cartItem) throws CartItemException;
	
	public CartItem isCartItemExist(Cart cart,Product product,String size);
	
}
