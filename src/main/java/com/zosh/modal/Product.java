package com.zosh.modal;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.zosh.user.domain.ProductCategory;
import com.zosh.user.domain.ProductColor;
import com.zosh.user.domain.ProductSize;
import com.zosh.user.domain.ProductSubCategory;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "discounted_price")
    private BigDecimal discountedPrice;
    
    @Column(name="discount_persent")
    private int discountPersent;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "brand")
    private String brand;

    @Column(name = "color")
    private Set<ProductColor> colors=new HashSet<>();

    @Column(name = "size")
    private Set<ProductSize> size=new HashSet<>();

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "rating")
    private float rating;

    @Column(name = "num_ratings")
    private int numRatings;
    
    private ProductCategory category;
    
    @Column(name="sub_category")
    private ProductSubCategory subCategory;
}
