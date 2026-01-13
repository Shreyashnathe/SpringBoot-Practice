package com.myPackage.service;

import com.myPackage.model.Product;
import com.myPackage.repo.OrderItemRepo;
import com.myPackage.repo.OrderRepo;
import com.myPackage.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderItemRepo orderItemRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(new Product(-1));
    }

    // Add a new product with image upload
    public Product addProduct(Product product, MultipartFile image) throws IOException {
        if (image != null && !image.isEmpty()) {
            product.setImageName(image.getOriginalFilename());
            product.setImageType(image.getContentType());
            product.setImageData(image.getBytes());
        }
        return productRepo.save(product);
    }


    // Update product details
    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {

        Product existing = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setBrand(product.getBrand());
        existing.setCategory(product.getCategory());
        existing.setPrice(product.getPrice());
        existing.setReleaseDate(product.getReleaseDate());
        existing.setProductAvailable(product.isProductAvailable());
        existing.setStockQuantity(product.getStockQuantity());

        if (imageFile != null && !imageFile.isEmpty()) {
            existing.setImageName(imageFile.getOriginalFilename());
            existing.setImageType(imageFile.getContentType());
            existing.setImageData(imageFile.getBytes());
        }

        return productRepo.save(existing);
    }


    // Delete a product by ID
    public void deleteProduct(int id) {

        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if (orderItemRepo.existsByProductId(id)) {
            throw new IllegalStateException("Product is used in orders. Cannot delete.");
        }
        productRepo.delete(product);
    }


    // Search products by keyword
    public List<Product> searchProducts(String keyword) {
        return productRepo.findByNameContainingOrDescriptionContainingOrCategoryContainingOrBrandContaining(
                keyword, keyword, keyword, keyword);
    }
}