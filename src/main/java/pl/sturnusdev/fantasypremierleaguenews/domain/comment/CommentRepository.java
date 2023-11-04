package pl.sturnusdev.fantasypremierleaguenews.domain.comment;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    List<Comment> findAllByArticleId(Long articleId);

    List<Comment> findAllByAuthorId(Long userId);
}
