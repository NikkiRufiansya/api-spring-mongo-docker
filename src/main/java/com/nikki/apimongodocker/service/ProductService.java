package com.nikki.apimongodocker.service;

import com.nikki.apimongodocker.model.Product;
import com.nikki.apimongodocker.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProduct(){
        return productRepository.findAll();
    }

    public Product getProductById(String id){
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("No Product By ID : "+ id));
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
}
