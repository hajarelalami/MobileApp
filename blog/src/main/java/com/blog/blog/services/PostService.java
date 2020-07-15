package com.blog.blog.services;

import data.entities.PostEntity;
import data.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postreposetry;
    public List<PostEntity> getAllPosts() {
        return postreposetry.findAll();
    }
    public List<PostEntity> getPostByUserId() {

        return postreposetry.findAll();
    }
}
