package com.zosh.modal;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.zosh.user.domain.ProductCategory;
import com.zosh.user.domain.ProductColor;
import com.zosh.user.domain.ProductSize;
import com.zosh.user.domain.ProductSubCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
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
    
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    
    @Column(name="sub_category")
    @Enumerated(EnumType.STRING)
    private ProductSubCategory subCategory;

    
	public Product() {
		
	}

	public Product(Long id, String name, String description, BigDecimal price, BigDecimal discountedPrice,
			int discountPersent, int quantity, String brand, Set<ProductColor> colors, Set<ProductSize> size,
			String imageUrl, float rating, int numRatings, ProductCategory category, ProductSubCategory subCategory) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.discountPersent = discountPersent;
		this.quantity = quantity;
		this.brand = brand;
		this.colors = colors;
		this.size = size;
		this.imageUrl = imageUrl;
		this.rating = rating;
		this.numRatings = numRatings;
		this.category = category;
		this.subCategory = subCategory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(BigDecimal discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public int getDiscountPersent() {
		return discountPersent;
	}

	public void setDiscountPersent(int discountPersent) {
		this.discountPersent = discountPersent;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Set<ProductColor> getColors() {
		return colors;
	}

	public void setColors(Set<ProductColor> colors) {
		this.colors = colors;
	}

	public Set<ProductSize> getSize() {
		return size;
	}

	public void setSize(Set<ProductSize> size) {
		this.size = size;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getNumRatings() {
		return numRatings;
	}

	public void setNumRatings(int numRatings) {
		this.numRatings = numRatings;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public ProductSubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(ProductSubCategory subCategory) {
		this.subCategory = subCategory;
	}
    
    
}
