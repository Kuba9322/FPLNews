package pl.sturnusdev.fantasypremierleaguenews.domain.comment;

import static pl.sturnusdev.fantasypremierleaguenews.tools.LocalDateTimeToString.localDateTimeToString;

public class CommentDtoMapper {

    static CommentDto map(Comment comment){
        return new CommentDto(comment.getId(),
                comment.getContent(),
                comment.getAuthor(),
                comment.getArticle(),
                localDateTimeToString(comment.getCreateTime()));
    }
}
