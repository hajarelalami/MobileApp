package com.blog.blog.services;

import data.entities.PostEntity;
import data.reposetry.PostReposetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostService {
    @Autowired

    private PostReposetry postreposetry;
    public List<PostEntity> getallposts() {

        return postreposetry.findAll();
    }
    public List<PostEntity> getpostbyuserid  () {

        return postreposetry.findAll();
    }
}
