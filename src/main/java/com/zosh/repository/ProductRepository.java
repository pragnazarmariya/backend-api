package com.zosh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.modal.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
