package com.blog.blog.data.repository;

import com.blog.blog.data.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query(value = "select * from blog_user where username = ?1", nativeQuery = true)
    Optional<UserEntity> findUserWithName(String username);
}