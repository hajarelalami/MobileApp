package com.blog.blog.services;

import com.blog.blog.authentification.CustomUserDetailsService;
import com.blog.blog.data.entities.ArticleEntity;
import com.blog.blog.data.entities.FileEntity;
import com.blog.blog.data.entities.User;
import com.blog.blog.data.repository.ArticleRepository;
import com.blog.blog.data.repository.FileRepository;
import com.blog.blog.data.repository.UserRepository;
import com.blog.blog.exception.FileException;
import com.blog.blog.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@Service
public class ArticleService {
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private CustomUserDetailsService userService;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private UserRepository userRepository;

    public ArticleService() {
    }

    public List<ArticleEntity> getAllArticles() {
        return articleRepository.findAll();
    }

    public List<FileEntity> getFilesByArticleId(long userId) {
        return fileRepository.findFilesByArticleId(userId);
    }

    public ArticleEntity getArticleById(long id) {
        return articleRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public ArticleEntity saveArticle(ArticleEntity articleEntity) {
        return this.articleRepository.save(articleEntity);
    }

    public FileEntity saveFile(MultipartFile file, int articleId, long userId) {

        FileEntity fileEntity = new FileEntity();
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        if (fileName.contains("..")) {
            throw new FileException("not a a valid file");
        }
        try {
            fileEntity.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            throw new FileException(e.getMessage());
        }
        fileEntity.setUserId(userId);
        fileEntity.setArticleId(articleId);
        return fileRepository.save(fileEntity);
    }

    public User getUserById(long userId){
        return userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("User name not found"));
    }

    public List<ArticleEntity> getArticleByUserId(long id) {
        return articleRepository.findArticlesByUserId(id);
    }
}
