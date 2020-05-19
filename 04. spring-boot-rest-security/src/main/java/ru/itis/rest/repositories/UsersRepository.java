package ru.itis.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.itis.rest.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);

    @Modifying
    @Query(value =  "DELETE FROM comments WHERE comments.article_id in (SELECT id from articles WHERE articles.user_id = :id);" + "DELETE FROM comments WHERE user_id = :id ;" + "DELETE FROM articles WHERE user_id = :id ;" + "DELETE FROM news WHERE user_id = :id ;" + "DELETE FROM itis_user WHERE id = :id ;", nativeQuery = true)
    void deleteById(Long id);
}