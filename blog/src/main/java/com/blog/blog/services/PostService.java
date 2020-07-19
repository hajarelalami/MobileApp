package com.blog.blog.services;

import com.blog.blog.data.entities.PostEntity;
import com.blog.blog.data.repository.PostRepository;
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

    public List<PostEntity> getPostByUserId(long userId) {

        return postreposetry.findPostsByUserId(userId);
    }

    public PostEntity addPost(PostEntity postEntity) {
        return this.postreposetry.save(postEntity);
    }


}
