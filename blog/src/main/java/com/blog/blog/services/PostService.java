package com.blog.blog.services;

import data.entities.PostEntity;
import data.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService  {
    @Autowired
    private PostRepository postreposetry;
     public List<PostEntity> getAllPosts() {

         return postreposetry.findAll();
    }
    public List<PostEntity> getPostByUserId(long userId) {

        return postreposetry.findPostsByUserId(userId);
    }
    public PostEntity addPost(PostEntity postEntity){
        return this.postreposetry.save(postEntity);
    }



}
