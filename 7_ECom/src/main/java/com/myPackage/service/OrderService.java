package com.myPackage.service;

import com.myPackage.model.Order;
import com.myPackage.model.OrderItem;
import com.myPackage.model.Product;
import com.myPackage.model.dto.OrderItemRequest;
import com.myPackage.model.dto.OrderRequest;
import com.myPackage.model.dto.OrderResponse;
import com.myPackage.repo.OrderRepo;
import com.myPackage.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductRepo productRepo;

    public OrderResponse placeOrder(OrderRequest request) {
        Order order = new Order();
        String orderId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        order.setOrderId(orderId);
        order.setCustomerName(request.customerName());
        order.setEmail(request.email());
        order.setStatus("PLACED");
        order.setOrderDate(LocalDate.now());

        List<OrderItem> orderItems = new ArrayList<>();
        for(OrderItemRequest itemRequest : request.items()) {
            Product product = productRepo.findById(itemRequest.productId()).orElseThrow(() -> new RuntimeException("Product not found"));

            product.setStockQuantity(product.getStockQuantity() - itemRequest.quantity());
            productRepo.save(product);
        }

        return null;
    }

    public List<OrderResponse> getAllOrderResponses() {
        return null;
    }
}
