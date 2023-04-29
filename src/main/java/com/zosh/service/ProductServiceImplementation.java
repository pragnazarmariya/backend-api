package com.zosh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zosh.exception.ProductException;

import com.zosh.modal.Product;

import com.zosh.repository.ProductRepository;
import com.zosh.user.domain.ProductSubCategory;

@Service
public class ProductServiceImplementation implements ProductService {
	
	private ProductRepository productRepository;
	private UserService userService;
	
	public ProductServiceImplementation(ProductRepository productRepository,UserService userService) {
		this.productRepository=productRepository;
		this.userService=userService;
	}
	

	@Override
	public Product createProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public String deleteProduct(Long productId) throws ProductException {
		
		Product product=findProductById(productId);
		
		productRepository.deleteById(product.getId());
		
		return "Product deleted Successfully";
	}

	@Override
	public String updateProduct(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product findProductById(Long id) throws ProductException {
		Optional<Product> opt=productRepository.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new ProductException("product not found with id "+id);
	}

	@Override
	public List<Product> findProductByCategory(ProductSubCategory category) {
		
		List<Product> products = productRepository.findByCategory(category);
		
		return products;
	}

	@Override
	public List<Product> searchProduct(String query) {
		List<Product> products=productRepository.searchProduct(query);
		return products;
	}

}
