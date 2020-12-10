package com.blog.blog.data.repository;

import com.blog.blog.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from blog_user where username = ?1", nativeQuery = true)
    Optional<User> findUserWithName(String username);
}