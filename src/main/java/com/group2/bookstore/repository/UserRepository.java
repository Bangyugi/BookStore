package com.group2.bookstore.repository;

import com.group2.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String emailOrPhone);

    boolean existsByUsername(String username);
}
