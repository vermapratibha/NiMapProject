package com.nimap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.model.Product;
import com.nimap.repository.ICategoryRepo;
import com.nimap.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ICategoryRepo categoryRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product, int categoryId) {
        com.nimap.model.Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category == null) 
        	return null;
        product.setCategory(category);
        return productRepository.save(product);
    }

    public Product updateProduct(int id, Product updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existing = optionalProduct.get();
            existing.setName(updatedProduct.getName());
            existing.setCategory(updatedProduct.getCategory());
            return productRepository.save(existing);
        }
        return null;
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}