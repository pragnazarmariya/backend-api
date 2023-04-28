package com.zosh.modal;



import com.zosh.user.domain.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @OneToMany
    private List<CartItem> cartItems;

    private LocalDateTime orderDate;

    private LocalDateTime deliveryDate;

    private String shippingAddress;

    private String billingAddress;

    @Embedded
    private PaymentDetails paymentDetails;

    private double totalPrice;

    private OrderStatus orderStatus;

    // constructors, getters and setters
}
