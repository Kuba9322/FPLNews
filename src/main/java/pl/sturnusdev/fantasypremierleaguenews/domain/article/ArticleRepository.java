package pl.sturnusdev.fantasypremierleaguenews.domain.article;

import org.springframework.data.repository.CrudRepository;
import pl.sturnusdev.fantasypremierleaguenews.user.User;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    List<Article> findAll();

    List<Article> findByAuthorId(Long userId);
}
