package com.myPackage.repo;

import com.myPackage.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findByNameContainingOrDescriptionContaining(String nameKeyword, String categoryKeyword);

    List<Product> findByPrice(Double price);
}
