package ru.itis.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.rest.dto.ArticleDto;
import ru.itis.rest.service.ArticleService;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/articles")
    public ResponseEntity<List<ArticleDto>> getArticles() {
        return ResponseEntity.ok(articleService.getArticles());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/article/{article-id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable("article-id") Long articleId) {
        return ResponseEntity.ok(articleService.getConcreteArticle(articleId));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/articles/{article-id}")
    public ResponseEntity<?> deleteArticle(@PathVariable("article-id") Long articleId) {
        articleService.deleteArticle(articleId);
        return ResponseEntity.accepted().build();
    }
}