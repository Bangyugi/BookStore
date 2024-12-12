package com.group2.bookstore.service.impl;

import com.group2.bookstore.dto.response.OrderResponse;
import com.group2.bookstore.entity.Order;
import com.group2.bookstore.exception.ResourceNotFoundException;
import com.group2.bookstore.repository.OrderRepository;
import com.group2.bookstore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    @Override
    public OrderResponse getOrderByOrderId(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));
        OrderResponse orderResponse = modelMapper.map(order, OrderResponse.class);
        return orderResponse;
    }

    @Override
    public OrderResponse getOrderByUserId(Long userId) {
        Order order = orderRepository.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException("Order", "userId", userId));
        OrderResponse orderResponse = modelMapper.map(order, OrderResponse.class);
        return orderResponse;
    }

}
