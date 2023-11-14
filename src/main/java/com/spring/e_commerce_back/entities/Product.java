package com.spring.e_commerce_back.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 150)
	private String title;

	@Column(nullable = false, length = 500)
	private String description;
	
	@Column(nullable = false)
	private String image;

	@Column(nullable = false)
	private int quantity;

	@Column(nullable = false)
	private String productCategory;

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", image=");
		builder.append(image);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", productCategory=");
		builder.append(productCategory);
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getTitle()=");
		builder.append(getTitle());
		builder.append(", getImage()=");
		builder.append(getImage());
		builder.append(", getDescription()=");
		builder.append(getDescription());
		builder.append(", getQuantity()=");
		builder.append(getQuantity());
		builder.append(", getProductCategory()=");
		builder.append(getProductCategory());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

	
	
	

}
