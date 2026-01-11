package com.myPackage.service;

import com.myPackage.model.Product;
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

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(new Product(-1));
    }

    public Product addProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());

        return productRepo.save(product);
    }

    public Product updateProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());

        return productRepo.save(product);
    }

    public Product deleteProduct(int id) {
        Product product = getProductById(id);
        if (product.getId() > 0) {
            productRepo.deleteById(id);
            return product;
        }
        return new Product(-1);
    }

    public List<Product> searchProducts(String keyword) {
        return productRepo.findByNameContainingOrDescriptionContainingOrCategoryContainingOrBrandContaining(
                keyword, keyword, keyword, keyword);
    }
}