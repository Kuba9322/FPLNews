package pl.sturnusdev.fantasypremierleaguenews.domain.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.sturnusdev.fantasypremierleaguenews.domain.article.Article;
import pl.sturnusdev.fantasypremierleaguenews.user.User;

@AllArgsConstructor
@Data
public class CommentDto {

    private Long id;
    private String content;
    private User author;
    private Article article;
    private String createTime;
}
