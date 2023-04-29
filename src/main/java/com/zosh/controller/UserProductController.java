package com.zosh.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.exception.ProductException;
import com.zosh.modal.Product;
import com.zosh.service.ProductService;
import com.zosh.user.domain.ProductSubCategory;

@RestController
@RequestMapping("/api/products")
public class UserProductController {
	
	private ProductService productService;
	
	public UserProductController(ProductService productService) {
		this.productService=productService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> findProductByCategoryHandler(@RequestParam ProductSubCategory category){
		
		List<Product> products=productService.findProductByCategory(category);
		
		return new ResponseEntity<List<Product>>(products,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/id/{productId}")
	public ResponseEntity<Product> findProductByIdHandler(@PathVariable Long ProductId) throws ProductException{
		
		Product product=productService.findProductById(ProductId);
		
		return new ResponseEntity<Product>(product,HttpStatus.ACCEPTED);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Product>> searchProductHandler(@RequestParam String q){
		
		List<Product> products=productService.searchProduct(q);
		
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		
	}
}
