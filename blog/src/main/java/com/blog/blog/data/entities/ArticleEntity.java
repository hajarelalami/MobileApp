package com.blog.blog.data.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "article")
public class ArticleEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "username")
    private String username;
    private String title;
    @Lob
    private String desc;
    private String difficulty;
    @ElementCollection
    private List<String> ingredients = new ArrayList<>();
    private long preparationTime;
    private long cockingTime;
    @ElementCollection
    private List<String> preparation = new ArrayList<>();
    private String type;
    @ElementCollection
    private List<String> etapes = new ArrayList<>();

    public ArticleEntity() {
    }

    public ArticleEntity(Long id, long userId, String username, String title, String desc, String difficulty, List<String> ingredients, long preparationTime, long cockingTime, List<String> preparation, String type, List<String> etapes) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.title = title;
        this.desc = desc;
        this.difficulty = difficulty;
        this.ingredients = ingredients;
        this.preparationTime = preparationTime;
        this.cockingTime = cockingTime;
        this.preparation = preparation;
        this.type = type;
        this.etapes = etapes;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public long getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(long preparationTime) {
        this.preparationTime = preparationTime;
    }

    public long getCockingTime() {
        return cockingTime;
    }

    public void setCockingTime(long cockingTime) {
        this.cockingTime = cockingTime;
    }

    public List<String> getPreparation() {
        return preparation;
    }

    public void setPreparation(List<String> preparation) {
        this.preparation = preparation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getEtapes() {
        return etapes;
    }

    public void setEtapes(List<String> etapes) {
        this.etapes = etapes;
    }
}
