package ru.itis.rest.service;

import ru.itis.rest.dto.ArticleDto;
import ru.itis.rest.dto.UserDto;
import ru.itis.rest.models.Article;

import java.util.List;

public interface ArticleService {
    void add(ArticleDto form, UserDto user, String photoUrl);
    List<ArticleDto> getArticles();
    ArticleDto getConcreteArticle(Long id);
    List<ArticleDto> getAllAuthorArticles(Long authorId);
    void deleteArticle(Long articleId);
}