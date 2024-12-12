package com.group2.bookstore.repository;

import com.group2.bookstore.entity.Order;
import com.group2.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("from Order o where o.user.userId=:userId")
    Optional<Order> findByUserId(Long userId);
}
