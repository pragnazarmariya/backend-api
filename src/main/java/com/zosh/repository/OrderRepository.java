package com.zosh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.modal.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
