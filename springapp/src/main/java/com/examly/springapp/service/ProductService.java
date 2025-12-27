package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Product;

public interface ProductService {
    Product saveProduct(Product product);   
    List<Product> getallProducts();
    Product getProductById(long id);
    Product updateProduct(long id,Product product);
    void deleteProduct(long id); 
}
