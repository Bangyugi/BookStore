package com.group2.bookstore.dto.response;

import com.group2.bookstore.entity.Book;
import com.group2.bookstore.entity.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponse {
    private Long orderItemId;
    private Long quantity;
    private Long totalPrice;
    private boolean status;
    private BookResponse book;
}
