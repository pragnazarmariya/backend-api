package com.zosh.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zosh.exception.CartItemException;
import com.zosh.modal.Cart;
import com.zosh.modal.CartItem;
import com.zosh.modal.Product;
import com.zosh.repository.CartItemRepository;

@Service
public class CartItemServiceImplementation implements CartItemService {
	
	private CartItemRepository cartItemRepository;
	
	public CartItemServiceImplementation(CartItemRepository cartItemRepository) {
		this.cartItemRepository=cartItemRepository;
	}

	@Override
	public CartItem createCartItem(CartItem cartItem) {
		
		cartItem.setQuantity(1);
		cartItem.setPrice(cartItem.getProduct().getPrice());
		
		CartItem createdCartItem=cartItemRepository.save(cartItem);
		
		return createdCartItem;
	}

	@Override
	public String updateCartItem(Long id, CartItem cartItem) throws CartItemException {
		
		Optional<CartItem> item=cartItemRepository.findById(cartItem.getId());
		
		if(item.isPresent()) {
			CartItem existingCartItem=item.get();
			existingCartItem.setQuantity(cartItem.getQuantity());
			existingCartItem.setPrice(existingCartItem.getQuantity()*existingCartItem.getProduct().getPrice());
			
		}
		
		throw new CartItemException("CartItem not found with id "+id);
	}

	@Override
	public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
		
		CartItem cartItem=cartItemRepository.isCartItemExist(cart, product, size, userId);
		
		return cartItem;
	}

}
