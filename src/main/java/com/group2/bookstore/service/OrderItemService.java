package com.group2.bookstore.service;


import com.group2.bookstore.dto.request.OrderItemRequest;
import com.group2.bookstore.dto.response.OrderItemResponse;
import com.group2.bookstore.dto.response.PageCustom;
import org.springframework.data.domain.Pageable;

public interface OrderItemService {

    OrderItemResponse createOrderItem(OrderItemRequest orderItemRequest);

    OrderItemResponse updateOrderItem(Long id, OrderItemRequest orderItemRequest);

    String updateOrderItemStatus(Long id);

    String deleteOrderItem(Long id);

    OrderItemResponse getOrderItemById(Long id);

    PageCustom<OrderItemResponse> getOrderItemByOrderId(Long orderId, Pageable pageable);

    PageCustom<OrderItemResponse> getAllOrderItem(Pageable pageable);

    PageCustom<OrderItemResponse> getAllOrderedHistory(Long orderId, Pageable pageable);

    PageCustom<OrderItemResponse> getAllOrderedHistoryByUserId(Long userId, Pageable pageable);
}
