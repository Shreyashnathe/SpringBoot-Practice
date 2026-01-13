package com.myPackage.repo;

import com.myPackage.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {

    boolean existsByProductId(int productId);
}
