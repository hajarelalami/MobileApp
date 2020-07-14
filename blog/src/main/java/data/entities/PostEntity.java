package data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="POST")
public class PostEntity {




    @Id
        @GeneratedValue
        private Long id;
        @Column(name = "user_id")
        private Long userId;
        private String title;
        private String picture;
        private String description;

    public PostEntity(Long id, Long userId, String title, String picture, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.picture = picture;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

