package com.blog.blog.Controllers;

import com.blog.blog.services.PostService;
import data.entities.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postservice;


    @GetMapping("/posts")
  public List<PostEntity> getAllPosts(){
    return this.postservice.getAllPosts();
}
@PostMapping("/post")

public PostEntity addPost(@RequestBody PostEntity postEntity){
return this.postservice.addPost(postEntity);
}
}
