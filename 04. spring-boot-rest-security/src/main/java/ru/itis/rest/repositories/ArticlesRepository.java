package ru.itis.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.itis.rest.models.Article;


import java.util.List;

public interface ArticlesRepository extends JpaRepository<Article, Long> {

    List<Article> findAll();
    List<Article> findByUserId(Long authorId);
    @Modifying
    @Query(value = "DELETE FROM comments WHERE comments.article_id = :id ;" + "DELETE FROM articles WHERE id = :id ;", nativeQuery = true)
    void deleteById(Long id);
}