package com.group2.bookstore.dto.response;

import com.group2.bookstore.entity.OrderItem;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Long orderId;
    private Long userId;
    private int quantity;
    private Long totalPrice;
    private boolean status;
    private Set<OrderItemResponse> orderItems;

}
