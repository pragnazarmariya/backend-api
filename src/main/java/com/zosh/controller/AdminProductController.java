package com.zosh.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.exception.ProductException;
import com.zosh.modal.Product;
import com.zosh.response.ApiResponse;
import com.zosh.service.ProductService;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {
	
	private ProductService productService;
	
	public AdminProductController(ProductService productService) {
		this.productService=productService;
	}
	
	@PostMapping("/")
	public ResponseEntity<Product> createProductHandler(@RequestBody Product product) throws ProductException{
		
		Product createdProduct = productService.createProduct(product);
		
		return new ResponseEntity<Product>(createdProduct,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<ApiResponse> deleteProductHandler(@PathVariable Long productId) throws ProductException{
		
		String msg=productService.deleteProduct(productId);
		
		ApiResponse res=new ApiResponse(msg,true);
		
		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
		
	}
	
	public ResponseEntity<List<Product>> findAllProduct(){
		
		List<Product> products=productService.getAllProducts();
		
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}

}
