package com.blog.blog.Controllers;

import com.blog.blog.data.entities.PostEntity;
import com.blog.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postservice;

    @GetMapping("/posts")
    public List<PostEntity> getAllPosts() {
        return this.postservice.getAllPosts();
    }

    @PostMapping("/post")
    public PostEntity addPost(@RequestBody PostEntity postEntity) {
        return this.postservice.addPost(postEntity);
    }

    @GetMapping("/posts/{id}")
    public List<PostEntity> getPostByUserId(@PathVariable long id) {
        return this.postservice.getPostByUserId(id);
    }
}
