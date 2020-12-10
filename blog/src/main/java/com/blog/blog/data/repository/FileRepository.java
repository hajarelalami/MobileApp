package com.blog.blog.data.repository;

import com.blog.blog.data.entities.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
    @Query(value = "SELECT * FROM  file WHERE article_id = ?1", nativeQuery = true)
    List<FileEntity> findFilesByArticleId(long articleId);


}
