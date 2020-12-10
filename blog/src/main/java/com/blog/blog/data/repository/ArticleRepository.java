package com.blog.blog.data.repository;

import com.blog.blog.data.entities.ArticleEntity;
import com.blog.blog.data.entities.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    @Query(value = "SELECT * FROM  article WHERE user_id = ?1", nativeQuery = true)
    List<ArticleEntity> findArticlesByUserId(long userId);

}
