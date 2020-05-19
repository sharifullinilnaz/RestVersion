package ru.itis.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.rest.models.Article;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {
    private Long id;
    private String name;
    private String geolocation;
    private String photoPath;
    private LocalDateTime date;
    private String text;
    private Long userId;

    public static ArticleDto from(Article article) {
        return ArticleDto.builder()
                .id(article.getId())
                .name(article.getName())
                .geolocation(article.getGeolocation())
                .photoPath(article.getPhotoPath())
                .date(article.getDate())
                .text(article.getText())
                .userId(article.getUser().getId())
                .build();
    }

    public static List<ArticleDto> from(List<Article> articles) {
        return articles.stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }

}

