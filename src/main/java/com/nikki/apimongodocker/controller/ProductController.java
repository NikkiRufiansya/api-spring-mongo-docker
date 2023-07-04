package com.nikki.apimongodocker.controller;

import com.nikki.apimongodocker.model.Product;
import com.nikki.apimongodocker.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(path = "/products")
    public ResponseEntity<?> getAllProducts(){
        Map<String, Object> map = new LinkedHashMap<>();
        List<Product> productList = productService.getProduct();
        if (!productList.isEmpty()){
            map.put("status", 200);
            map.put("message", "success");
            map.put("data", productList);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }else {
            map.clear();
            map.put("status", 404);
            map.put("message", "Data Not Found");
            map.put("data", productList);
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(path = "/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable String id){
        Map<String, Object> map = new LinkedHashMap<>();
        try {
            Product product = productService.getProductById(id);
            map.put("status", 200);
            map.put("message", "success");
            map.put("data", product);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }catch (Exception e){
            map.clear();
            map.put("message", "success");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/products")
    public ResponseEntity<?> saveProduct(@RequestBody Product product){
        Map<String, Object> map = new LinkedHashMap<>();
        productService.saveProduct(product);
        map.put("status", 200);
        map.put("message","Product Saved Successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
