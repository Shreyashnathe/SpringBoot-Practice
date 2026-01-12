package com.myPackage.service;

import com.myPackage.model.Order;
import com.myPackage.model.dto.OrderRequest;
import com.myPackage.model.dto.OrderResponse;
import com.myPackage.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public OrderResponse placeOrder(OrderRequest request) {
        Order order = new Order();
        String orderId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        order.setOrderId(orderId);
        order.setCustomerName(request.customerName());
        order.setEmail(request.email());
        return null;
    }

    public List<OrderResponse> getAllOrderResponses() {
        return null;
    }
}
