package com.zosh.modal;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "discounted_price")
    private int discountedPrice;
    
    @Column(name="discount_persent")
    private int discountPersent;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "brand")
    private String brand;

    @Column(name = "color")
    private String color;

    @Embedded
    @ElementCollection
    @Column(name = "size")
    private Set<Size> size=new HashSet<>();

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "rating")
    private float rating;

    @Column(name = "num_ratings")
    private int numRatings;
    

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    
	public Product() {
		
	}

	public Product(Long id, String title, String description, int price, int discountedPrice, int discountPersent,
			int quantity, String brand, String color, Set<Size> size, String imageUrl, float rating, int numRatings,
			Category category) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.discountPersent = discountPersent;
		this.quantity = quantity;
		this.brand = brand;
		this.color = color;
		this.size = size;
		this.imageUrl = imageUrl;
		this.rating = rating;
		this.numRatings = numRatings;
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(int discountedPrice) {
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Set<Size> getSize() {
		return size;
	}

	public void setSize(Set<Size> size) {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, category, color, description, discountPersent, discountedPrice, id, imageUrl,
				numRatings, price, quantity, rating, size, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(category, other.category)
				&& Objects.equals(color, other.color) && Objects.equals(description, other.description)
				&& discountPersent == other.discountPersent && discountedPrice == other.discountedPrice
				&& Objects.equals(id, other.id) && Objects.equals(imageUrl, other.imageUrl)
				&& numRatings == other.numRatings && price == other.price && quantity == other.quantity
				&& Float.floatToIntBits(rating) == Float.floatToIntBits(other.rating)
				&& Objects.equals(size, other.size) && Objects.equals(title, other.title);
	}

	

   
}
