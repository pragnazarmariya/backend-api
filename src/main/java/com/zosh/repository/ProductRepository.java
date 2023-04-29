package com.zosh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zosh.modal.Product;
import com.zosh.user.domain.ProductSubCategory;


public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p From Product p Where p.subCategory=:category")
	public List<Product> findByCategory(@Param("category") ProductSubCategory category);
	
	@Query("SELECT p From Product p where LOWER(p.name) Like %:query% OR LOWER(p.description) Like %:query% OR LOWER(p.brand) LIKE %:query% OR LOWER(p.subCategory) LIKE %:query% ")
	public List<Product> searchProduct(@Param("query")String query);
}
