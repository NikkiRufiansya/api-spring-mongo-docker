package com.nikki.apimongodocker.repository;

import com.nikki.apimongodocker.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
