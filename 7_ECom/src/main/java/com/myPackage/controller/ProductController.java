package com.myPackage.controller;

import com.myPackage.model.Product;
import com.myPackage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    @Autowired
    private ProductService service;

//    public ProductController(ProductService service) {
//        this.service = service;
//    }

    //Get All Products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        Product product = service.getProductById(id);
        if(product.getId() > 0) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Add Product
    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(service.addProduct(product), HttpStatus.CREATED);
    }

    //Update Product
    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    //Delete Product
    @DeleteMapping("/product/{id}")
    public Product deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    //Find Products by Keyword
    @GetMapping("/products/keyword/{keyword}")
    public List<Product> findByKeyword(@PathVariable String keyword) {
        return service.findByKeyword(keyword);
    }

    //Find Products by Price
    @GetMapping("/products/price/{price}")
    public List<Product> findByPrice(@PathVariable Double price) {
        return service.findByPrice(price);
    }

}
