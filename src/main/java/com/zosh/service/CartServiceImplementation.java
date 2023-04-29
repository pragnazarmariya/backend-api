package com.zosh.service;

import org.springframework.stereotype.Service;

import com.zosh.modal.Cart;
import com.zosh.modal.CartItem;
import com.zosh.repository.CartRepository;

@Service
public class CartServiceImplementation implements CartService{
	
	private CartRepository cartRepository;
	private CartItemService cartItemService;
	
	
	public CartServiceImplementation(CartRepository cartRepository,CartItemService cartItemService) {
		this.cartRepository=cartRepository;
	}

	@Override
	public Cart createCart(Cart cart) {
		Cart createdCart=cartRepository.save(cart);
		return createdCart;
	}

	@Override
	public String addCartItem(Long userId, CartItem cartItem) {
		Cart cart=cartRepository.findByUserId(userId);
		
		CartItem isPresent=cartItemService.isCartItemExist(cart, cartItem.getProduct(), cartItem.getSize());
		
		
		
		if(isPresent==null) {
			CartItem createdCartItem=cartItemService.createCartItem(cartItem);
			cart.getCartItems().add(createdCartItem);
		}
		
		
		return "Item Add To Cart";
	}

}
