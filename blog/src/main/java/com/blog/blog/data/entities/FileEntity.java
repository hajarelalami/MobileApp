package com.blog.blog.data.entities;

import javax.persistence.*;

@Entity(name = "file")
public class FileEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "article_id")
    private long articleId;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    public FileEntity() {
    }

    public FileEntity(Long id, long userId, long articleId, String image) {
        this.id = id;
        this.userId = userId;
        this.articleId = articleId;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

