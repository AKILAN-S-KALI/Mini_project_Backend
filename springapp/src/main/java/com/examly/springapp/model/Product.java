package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    private String productName;
    private String description;
    private Double price;
    private Integer stockQuantity;

    public Product() {
    }

  

public Product(String productName, String description, Double price, Integer stockQuantity) {
    this.productName = productName;
    this.description = description;
    this.price = price;
    this.stockQuantity = stockQuantity;
}



public long getProductId() {
    return productId;
}



public void setProductId(long productId) {
    this.productId = productId;
}



public String getProductName() {
    return productName;
}



public void setProductName(String productName) {
    this.productName = productName;
}



public String getDescription() {
    return description;
}



public void setDescription(String description) {
    this.description = description;
}



public Double getPrice() {
    return price;
}



public void setPrice(Double price) {
    this.price = price;
}



public Integer getStockQuantity() {
    return stockQuantity;
}



public void setStockQuantity(Integer stockQuantity) {
    this.stockQuantity = stockQuantity;
}     
    
}
