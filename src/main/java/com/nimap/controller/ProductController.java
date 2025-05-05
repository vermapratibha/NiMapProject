package com.nimap.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.nimap.model.Product;
import com.nimap.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/api/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/api/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product, @RequestParam int categoryId) {
        Product created = productService.addProduct(product, categoryId);
        if (created == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Invalid category
        }
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/api/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        Product updated = productService.updateProduct(id, updatedProduct);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/api/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
