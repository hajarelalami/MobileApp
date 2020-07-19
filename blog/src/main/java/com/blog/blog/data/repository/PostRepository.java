package com.blog.blog.data.repository;

import com.blog.blog.data.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    @Query(value = "SELECT * FROM  post WHERE user_id = ?1", nativeQuery = true)
    List<PostEntity> findPostsByUserId(long userId);

}
