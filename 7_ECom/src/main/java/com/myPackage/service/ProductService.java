package com.myPackage.service;

import com.myPackage.model.Product;
import com.myPackage.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

//    public ProductService(ProductRepo repo) {
//        this.repo = repo;
//    }

    // Get All Products
    public List<Product> getProducts() {
        return repo.findAll();
    }

    // Get Product by ID
    public Product getProductById(int id) {
        return repo.findById(id).get();
    }

    // Add Product
    public Product addProduct(Product product) {
        return repo.save(product);
    }

    // Update Product
    public Product updateProduct(Product product) {
        Product existing = repo.findById(product.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setBrand(product.getBrand());
        existing.setCategory(product.getCategory());
        existing.setPrice(product.getPrice());
        existing.setReleaseDate(product.getReleaseDate());
        existing.setProductAvailable(product.isProductAvailable());
        existing.setStockQuantity(product.getStockQuantity());

        return repo.save(existing);
    }

    // Delete Product
    public Product deleteProduct(int id) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        repo.delete(product);
        return product;
    }


    // Find Products by Keyword
    public List<Product> findByKeyword(String keyword) {
        return repo.findByNameContainingOrDescriptionContaining(keyword, keyword);
    }

    // Find Products by Price
    public List<Product> findByPrice(Double price) {
        return repo.findByPrice(price);
    }

}
