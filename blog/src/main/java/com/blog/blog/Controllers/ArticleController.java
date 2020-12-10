package com.blog.blog.Controllers;

import com.blog.blog.authentification.UserPrincipal;
import com.blog.blog.authentification.CustomUserDetailsService;
import com.blog.blog.data.entities.ArticleEntity;
import com.blog.blog.data.entities.FileEntity;
import com.blog.blog.data.entities.User;
import com.blog.blog.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @GetMapping("public/article")
    public List<ArticleEntity> getAllArticles() {
        return this.articleService.getAllArticles();
    }

    @PostMapping("/article")
    public ArticleEntity saveArticle(@RequestBody ArticleEntity articleEntity) {
        final UserPrincipal userDetails = (UserPrincipal)userDetailsService.loadUserByUsername(userDetailsService.getUserInfo().getUsername());
        articleEntity.setUserId(userDetails.getId());
        articleEntity.setUsername(userDetails.getUsername());
        return this.articleService.saveArticle(articleEntity);
    }

    @GetMapping("public/files/article/{id}")
    public List<FileEntity> getFilesByArticleId(@PathVariable long id) {
        return this.articleService.getFilesByArticleId(id);
    }

    @GetMapping("public/article/{id}")
    public ArticleEntity getArticleById(@PathVariable long id) {
        return this.articleService.getArticleById(id);
    }

    @GetMapping("public/articles/user/{id}")
    public List<ArticleEntity> getArticleByUserId(@PathVariable long id) {
        return this.articleService.getArticleByUserId(id);
    }

    @PostMapping("/file/add")
    public FileEntity saveFile(@RequestParam("file") MultipartFile file,
                               @RequestParam("articleId") String articleId) {
        final UserPrincipal userDetails = (UserPrincipal)userDetailsService.loadUserByUsername(userDetailsService.getUserInfo().getUsername());
        return articleService.saveFile(file, Integer.parseInt(articleId), userDetails.getId());
    }

    @GetMapping("public/user/{id}")
    public User getUserById(@PathVariable long id) {
        return this.articleService.getUserById(id);
    }

}
