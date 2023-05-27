package pl.sturnusdev.fantasypremierleaguenews.domain.article;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    List<Article> findAll();
}
