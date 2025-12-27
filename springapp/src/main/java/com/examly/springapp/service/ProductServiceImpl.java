package com.examly.springapp.service;

import java.util.List;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);

    }

    @Override
    public List<Product> getallProducts() {
        return productRepo.findAll();

    }

    @Override
    public Product getProductById(long id) {
        return productRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Production not found "));

    }

    @Override
    public Product updateProduct(long id, Product product) {
        Product existingpProduct = getProductById(id);
        existingpProduct.setProductName(product.getProductName());
        existingpProduct.setDescription(product.getDescription());
        existingpProduct.setPrice(product.getPrice());
        existingpProduct.setStockQuantity(product.getStockQuantity());

        return productRepo.save(existingpProduct);

    }

    @Override
    public void deleteProduct(long id) {
        Product product = getProductById(id);
        productRepo.delete(product);

    }


    
}
