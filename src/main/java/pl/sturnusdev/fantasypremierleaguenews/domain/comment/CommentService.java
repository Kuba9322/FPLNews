package pl.sturnusdev.fantasypremierleaguenews.domain.comment;

import org.springframework.stereotype.Service;
import pl.sturnusdev.fantasypremierleaguenews.user.UserDto;

import java.util.List;

@Service
public class CommentService {

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    private CommentRepository commentRepository;

    public List<CommentDto> findAllCommentsByArticleId(Long articleId){
        return commentRepository.findAllByArticleId(articleId)
                .stream()
                .map(CommentDtoMapper::map)
                .toList();
    }

    public List<CommentDto> findAllCommentsByAuthor(UserDto user) {
        return commentRepository.findAllByAuthorId(user.getId())
                .stream()
                .map(CommentDtoMapper::map)
                .toList();
    }
}
