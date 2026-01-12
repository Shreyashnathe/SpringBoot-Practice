package com.myPackage.service;

import com.myPackage.model.dto.OrderRequest;
import com.myPackage.model.dto.OrderResponse;
import com.myPackage.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        return orderRepo.
    }

    public List<OrderResponse> getAllOrderResponses() {
        return null;
    }
}
