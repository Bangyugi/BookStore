package com.group2.bookstore.service;

import com.group2.bookstore.dto.response.OrderResponse;

public interface OrderService {
    OrderResponse getOrderByOrderId(Long orderId);

    OrderResponse getOrderByUserId(Long userId);
}
