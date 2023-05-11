package com.zosh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zosh.modal.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("SELECT o from Order o where o.user.id=:userId And o.orderStatus=PLACED ")
	public List<Order> getUsersOrders(@Param("userId") Long userId);
}
