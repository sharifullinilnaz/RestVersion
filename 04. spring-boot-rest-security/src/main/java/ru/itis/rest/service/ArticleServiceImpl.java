package ru.itis.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.rest.dto.ArticleDto;
import ru.itis.rest.dto.UserDto;
import ru.itis.rest.models.Article;
import ru.itis.rest.models.User;
import ru.itis.rest.repositories.ArticlesRepository;
import ru.itis.rest.repositories.UsersRepository;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticlesRepository articlesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<ArticleDto> getArticles() {
        return ArticleDto.from(articlesRepository.findAll());
    }

    @Override
    public void add(ArticleDto form, UserDto user, String photoUrl) {
        Article article = Article.builder()
                .name(form.getName())
                .geolocation(form.getGeolocation())
                .photoPath(photoUrl)
                .date(LocalDateTime.now())
                .text(form.getText())
                .build();
        articlesRepository.save(article);
        User userToSave = usersRepository.getOne(user.getId());
        article.setUser(userToSave);
        usersRepository.save(userToSave);
    }

    @Override
    public ArticleDto getConcreteArticle(Long id) {
        return ArticleDto.from(articlesRepository.getOne(id));
    }

    @Override
    public List<ArticleDto> getAllAuthorArticles(Long authorId) {
        return ArticleDto.from(articlesRepository.findByUserId(authorId));
    }

    @Override
    public void deleteArticle(Long articleId) {
        articlesRepository.deleteById(articleId);
    }
}